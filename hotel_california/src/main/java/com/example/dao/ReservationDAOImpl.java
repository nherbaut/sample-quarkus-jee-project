package com.example.dao;

import com.example.Exception.NoAvailableRoomException;
import com.example.model.Reservation;
import com.example.model.Room;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.common.hotel.model.Cancellation;
import org.common.hotel.model.ReservationEntity;
import org.common.hotel.model.ReservationInfos;

import java.time.LocalDate;

@ApplicationScoped
public class ReservationDAOImpl implements ReservationDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ReservationEntity makeReservation(ReservationEntity reservation) throws NoAvailableRoomException {
        Room room = null;
        try {
            room = entityManager.createQuery("select r from Room r where r.id=: roomNumber", Room.class).setParameter("roomNumber", reservation.getRoomId()).getSingleResult();
        }
        catch (NoResultException exception){
            throw new NoAvailableRoomException();
        }

        //create new reservation
        ReservationInfos reservationInfos = new ReservationInfos();
        reservationInfos.setUserId(reservation.getUserId());
        reservationInfos.setRoomId(reservation.getRoomId());

        Reservation newReservation = new Reservation();
        newReservation.setId(reservation.getId());
        newReservation.setNbrGuest(reservation.getNbrGuest());
        newReservation.setRoomId(reservation.getRoomId());
        newReservation.setUserId(reservation.getUserId());
        newReservation.setStartDate(reservation.getStartDate());
        newReservation.setEndDate(reservation.getEndDate());

        entityManager.persist(newReservation);

        return reservation;
    }

    @Override
    public void cancelReservation(Cancellation cancellation) {

    }

    @Override
    public boolean isRoomAvailable(ReservationEntity reservation) throws NoAvailableRoomException {
        return false;
    }
}
