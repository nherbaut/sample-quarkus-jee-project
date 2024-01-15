package com.hotel.service.imp;

import com.hotel.Exception.NoAvailableReservationException;
import com.hotel.Exception.NoAvailableRoomException;
import com.hotel.dao.ReservationDAOImpl;
import com.hotel.model.Reservation;
import com.hotel.service.ReservationService;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationRequestDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.UpdateReservationDTO;
import jakarta.inject.Inject;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    @Inject
    ReservationDAOImpl reservationDAO;
    @Override
    public Reservation makeReservation(ReservationRequestDTO reservation) throws NoAvailableRoomException {
        return reservationDAO.makeReservation(reservation);

    }

    @Override
    public UpdateReservationDTO cancelReservation(String cancellation) throws NoAvailableReservationException {
        return reservationDAO.cancelReservation(cancellation);
    }

    @Override
    public boolean isRoomAvailable(ReservationRequestDTO reservation) throws NoAvailableRoomException {
        return false;
    }

}
