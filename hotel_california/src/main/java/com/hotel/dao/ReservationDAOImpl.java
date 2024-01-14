package com.hotel.dao;

import com.hotel.Exception.NoAvailableReservationException;
import com.hotel.Exception.NoAvailableRoomException;
import com.hotel.model.*;
import com.hotel.service.RoomService;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationRequestDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ApplicationScoped
public class ReservationDAOImpl implements ReservationDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    RoomService roomService;

    @Override
    @Transactional(rollbackOn = SQLException.class)
    public Reservation makeReservation(ReservationRequestDTO request) throws NoAvailableRoomException {
        // check if the room is available on those dates
        LocalDate from = request.getFrom();
        LocalDate to = request.getTo();
        int roomId = request.getRoomId();

        boolean isAvailable = roomService.isRoomAvailable(roomId, from, to);
        if(!isAvailable){
            throw new NoAvailableRoomException();
        }
        // room
        Room room =  entityManager.createQuery("SELECT r from Room r where id = :id ", Room.class).setParameter("id", roomId).getSingleResult();

        double totalPrice = room.getPrice() * Period.between(from, to).get(ChronoUnit.DAYS);
        Set<ReservationOptions> optionsSet = new HashSet<>();

        if(!request.getOptionsId().isEmpty()){
            optionsSet = new HashSet<>(entityManager.createQuery("Select o from ReservationOptions  o where id in :ids ", ReservationOptions.class)
                    .setParameter("ids", request.getOptionsId())
                    .getResultList());
            totalPrice += optionsSet.stream().mapToDouble(ReservationOptions::getPrice).sum();

        }
        // get the user with the current request
        User user = entityManager.createQuery("select  u from User u where id = :id", User.class).setParameter("id", request.getUserId())
                .getSingleResult();
        if(Objects.isNull(user)){
            throw new RuntimeException("User not found");
        }

        Reservation reservation = new Reservation(request.getGuests(), user, room, from, to, totalPrice, optionsSet, StatusEnum.CONFIRMED, request.getBookingReservationId());
        return entityManager.merge(reservation);
    }
    @Transactional
    @Override
    public boolean cancelReservation(String cancelReservation) throws NoAvailableReservationException {
        //Check if there is a reservation
        Reservation res = null;
        try {
            res = entityManager.createQuery("select res from Reservation res where bookingReservationId = :reservationNumber", Reservation.class).setParameter("reservationNumber", cancelReservation).getSingleResult();
            if (res != null){
                entityManager.createQuery("delete  from Reservation r where bookingReservationId = :reservationNumber").setParameter("reservationNumber", cancelReservation).executeUpdate();
            return true;
            }
        }
        catch (NoResultException noResultException){
            throw new NoAvailableReservationException();
        }
    return false;
    }

}
