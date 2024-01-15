package com.hotel.service.imp;

import com.hotel.Exception.NoAvailableRoomException;
import com.hotel.model.Room;
import com.hotel.service.RoomService;
import fr.pantheonsorbonne.ufr27.miage.dto.AvailabilityDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestScoped
public class RoomServiceImpl implements RoomService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<AvailabilityDTO> getRooms() {
        // over a period of 7 days
        // find all reservation within now, now + 7 days
        LocalDate now = LocalDate.now().plusMonths(11), delta = LocalDate.now().plusMonths(11).plusDays(7);
        List<ReservationDTO> reservations = entityManager.createQuery(""" 

                SELECT new fr.pantheonsorbonne.ufr27.miage.dto.ReservationDTO(r.startDate, r.endDate, r.room.id) from Reservation  r
                WHERE r.startDate >= :start and r.endDate <= :end            
                """, ReservationDTO.class)
                .setParameter("start", now)
                .setParameter("end", delta)
                .getResultList();

        Map<Integer, List<ReservationDTO>> map = reservations.stream().collect(Collectors.groupingBy(ReservationDTO::getRoomId));

        List<AvailabilityDTO> availabilityDTOS = new ArrayList<>();
        // for every room find available days between reservation
        for(Map.Entry<Integer, List<ReservationDTO>> entry : map.entrySet()){
            List<ReservationDTO> res = entry.getValue();
            for (int i  = 0; i < res.size() - 1; i++) {
                ReservationDTO current = res.get(i), next = res.get(i + 1 );
                if(Period.between(current.getTo(), next.getFrom()).get(ChronoUnit.DAYS) >= 1) {
                    availabilityDTOS.add(new AvailabilityDTO(entry.getKey(), current.getTo(), next.getFrom()));
                }
            }
        }


        List<AvailabilityDTO> roomList =  entityManager.createQuery("Select r.id from Room r where r.id not in (select distinct  r.room.id from Reservation r  " +
                        "                WHERE r.startDate <= :start and r.endDate <= :end)", Integer.class)
                .setParameter("start", now)
                .setParameter("end", delta)
                .getResultList()
                .stream().map(e -> new AvailabilityDTO(e, now, delta))
                .toList();
        availabilityDTOS.addAll(roomList);
        return availabilityDTOS;

    }


    @Override
    public boolean isRoomAvailable(Integer roomId, LocalDate from, LocalDate to) {

        Integer isAvailable = (Integer) entityManager.createNativeQuery("""
            Select not exists(select 1 from Reservation where not(end_date < ? or start_date > ?))
            """, Integer.class).setParameter(1, from).setParameter(2, to).getSingleResult();
        return isAvailable == 1;
    }

    @Override
    public Room findAvailableRoom(LocalDate from, LocalDate to, int numberOfBeds) throws NoAvailableRoomException {

        try{
            Room room = entityManager.createQuery(
                            "SELECT r FROM Room r " +
                                    "WHERE r.id NOT IN (" +
                                    "   SELECT res.room.id FROM Reservation res " +
                                    "   WHERE NOT(res.endDate < :startDate OR res.startDate > :endDate)" +
                                    ") AND r.nbrBed >= :nbrBeds " +
                                    "ORDER BY r.nbrBed ASC", Room.class)
                    .setParameter("startDate",from)
                    .setParameter("endDate", to)
                    .setParameter("nbrBeds", numberOfBeds)
                    .setMaxResults(1)
                    .getSingleResult();

            if(!Objects.isNull(room)){
                return room;
            }

        }catch (Exception e){
            throw new NoAvailableRoomException();
        }
        return null;
    }
}
