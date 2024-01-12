package com.example.resources;

import com.example.dao.ReservationDAOImpl;
import com.example.service.RoomService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.common.hotel.model.RoomEntity;

import java.util.List;

@Path("/hotel_paradiso")
public class HotelParadisoAPI {

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
}
