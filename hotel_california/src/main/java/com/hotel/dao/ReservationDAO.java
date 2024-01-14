package com.hotel.dao;

import com.hotel.Exception.NoAvailableReservationException;
import com.hotel.Exception.NoAvailableRoomException;
import com.hotel.model.Reservation;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationRequestDTO;

public interface ReservationDAO {
    Reservation makeReservation(ReservationRequestDTO request) throws NoAvailableRoomException;
    boolean cancelReservation(String cancellation) throws NoAvailableReservationException;
    boolean changeReservationStatus(String reservationStatus, String bookingReservationId) throws NoAvailableReservationException;

}
