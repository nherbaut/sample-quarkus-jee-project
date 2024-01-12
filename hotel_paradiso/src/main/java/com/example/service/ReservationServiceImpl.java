package com.example.service;

import com.example.Exception.NoAvailableRoomException;
import com.example.dao.ReservationDAOImpl;
import jakarta.inject.Inject;
import org.common.hotel.model.Cancellation;
import org.common.hotel.model.ReservationEntity;

public class ReservationServiceImpl implements ReservationService {
    @Inject
    ReservationDAOImpl reservationDAO;
    @Override
    public ReservationEntity makeReservation(ReservationEntity reservation) throws NoAvailableRoomException {
        return reservationDAO.makeReservation(reservation);

    }

    @Override
    public void cancelReservation(Cancellation cancellation) {

    }

    @Override
    public boolean isRoomAvailable(ReservationEntity reservation) throws NoAvailableRoomException {
        return false;
    }
}
