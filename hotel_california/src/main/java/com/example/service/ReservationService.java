package com.example.service;

import com.example.Exception.NoAvailableRoomException;
import org.common.hotel.model.ReservationEntity;
import org.common.hotel.model.Cancellation;


public interface ReservationService {
    ReservationEntity makeReservation(ReservationEntity reservation) throws NoAvailableRoomException;
    void cancelReservation(Cancellation cancellation);
    boolean isRoomAvailable(ReservationEntity reservation) throws NoAvailableRoomException;

}
