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
import org.glassfish.jaxb.core.v2.TODO;

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

    @Inject
    UserDAO userDAO;

    @Override
    @Transactional(rollbackOn = SQLException.class)
    public Reservation makeReservation(ReservationRequestDTO request) throws NoAvailableRoomException {
        //check if the user exist
        User user = null;
        boolean doesUserExist = userDAO.doesUserExist(request.getUser());
        if(doesUserExist == false){
            user = userDAO.createUser(request.getUser());
        }

        // check if the room is available on those dates
        LocalDate from = request.getFrom();
        LocalDate to = request.getTo();


        // finding a room that is available between two dates and have sufficient beds
        Room room = roomService.findAvailableRoom(request.getFrom(), request.getTo(), request.getGuests());


        double totalPrice = room.getPrice() * Period.between(from, to).get(ChronoUnit.DAYS);
        Set<ReservationOptions> optionsSet = new HashSet<>();

        if(!request.getOptionsNames().isEmpty()){
            optionsSet = new HashSet<>(entityManager.createQuery("Select o from ReservationOptions  o where name in :names", ReservationOptions.class)
                    .setParameter("names", request.getOptionsNames())
                    .getResultList());
            totalPrice += optionsSet.stream().mapToDouble(ReservationOptions::getPrice).sum();

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