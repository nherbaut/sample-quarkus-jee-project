package com.hotel.service;

import com.hotel.Exception.NoAvailableReservationException;
import com.hotel.Exception.NoAvailableRoomException;
import com.hotel.model.Reservation;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationRequestDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.UpdateReservationDTO;



public interface ReservationService {
    Reservation makeReservation(ReservationRequestDTO reservation) throws NoAvailableRoomException;
    UpdateReservationDTO cancelReservation(String cancellation) throws NoAvailableReservationException;
    boolean isRoomAvailable(ReservationRequestDTO reservation) throws NoAvailableRoomException;

}
