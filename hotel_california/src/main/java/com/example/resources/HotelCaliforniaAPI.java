package com.example.resources;

import com.example.Exception.NoAvailableRoomException;
import com.example.dao.ReservationDAOImpl;
import com.example.service.ReservationService;
import com.example.service.RoomService;
import jakarta.inject.Inject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.common.hotel.model.ReservationEntity;
import org.common.hotel.model.RoomEntity;

import java.util.List;

@Path("/hotel_california")
public class HotelCaliforniaAPI {
    @Inject
    RoomService roomService;
    @Inject
    ReservationDAOImpl reservationService;

    @Path("rooms")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoomEntity> getAllRooms(){
        return roomService.getRooms();
    }
/*
    todo : refactor to make it work with both hotel modules
    @Path("make_reservation")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public boolean makeReservation(ReservationEntity reservation) throws NoAvailableRoomException {
        reservationService.makeReservation(reservation);
        return true;
    }

 */

}
