package com.example.service;

import com.example.Exception.NoAvailableRoomException;
import org.common.hotel.model.Cancellation;
import org.common.hotel.model.ReservationEntity;


public interface ReservationService {
    ReservationEntity makeReservation(ReservationEntity reservation) throws NoAvailableRoomException;
    void cancelReservation(Cancellation cancellation);
    boolean isRoomAvailable(ReservationEntity reservation) throws NoAvailableRoomException;

}
