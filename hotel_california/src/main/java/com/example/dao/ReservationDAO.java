package com.example.dao;

import com.example.Exception.NoAvailableRoomException;
import org.common.hotel.model.Cancellation;
import org.common.hotel.model.ReservationEntity;

public interface ReservationDAO {
    ReservationEntity makeReservation(ReservationEntity reservation) throws NoAvailableRoomException;
    void cancelReservation(Cancellation cancellation);
    boolean isRoomAvailable(ReservationEntity reservation) throws NoAvailableRoomException;
}
