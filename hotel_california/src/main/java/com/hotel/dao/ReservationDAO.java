package com.hotel.dao;

import com.hotel.Exception.NoAvailableReservationException;
import com.hotel.Exception.NoAvailableRoomException;
import com.hotel.model.Reservation;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationRequestDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.UpdateReservationDTO;

public interface ReservationDAO {
    Reservation makeReservation(ReservationRequestDTO request) throws NoAvailableRoomException;
    UpdateReservationDTO cancelReservation(String cancellation) throws NoAvailableReservationException;
    UpdateReservationDTO changeReservationStatus(String reservationStatus, String bookingReservationId) throws NoAvailableReservationException;

}
