package com.hotel.service;

import com.hotel.Exception.NoAvailableReservationException;
import com.hotel.Exception.NoAvailableRoomException;
import com.hotel.model.Reservation;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationRequestDTO;

import java.util.List;


public interface ReservationService {
    Reservation makeReservation(ReservationRequestDTO reservation) throws NoAvailableRoomException;
    boolean cancelReservation(String cancellation) throws NoAvailableReservationException;
    boolean isRoomAvailable(ReservationRequestDTO reservation) throws NoAvailableRoomException;

    Reservation saveReservation(Reservation reservation);

    Reservation getReservationById(int reservationId);

    List<Reservation> getAllReservations();

}
