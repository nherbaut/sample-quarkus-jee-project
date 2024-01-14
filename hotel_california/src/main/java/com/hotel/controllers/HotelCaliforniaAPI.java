package com.hotel.controllers;

import com.hotel.Exception.NoAvailableReservationException;
import com.hotel.Exception.NoAvailableRoomException;
import com.hotel.dao.ReservationDAOImpl;
import com.hotel.model.Reservation;
import com.hotel.model.ReservationOptions;
import com.hotel.service.ReservationOptionsService;
import com.hotel.service.RoomService;
import fr.pantheonsorbonne.ufr27.miage.dto.AvailabilityDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationRequestDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationResponseDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/hotel")
public class HotelCaliforniaAPI {
    @Inject
    RoomService roomService;
    @Inject
    ReservationDAOImpl reservationService;
    @Inject
    ReservationOptionsService reservationOptionsService;

    @Path("rooms")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AvailabilityDTO> getAllRooms(){
        return roomService.getRooms();
    }


    @Path("make_reservation")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public ReservationResponseDTO makeReservation(ReservationRequestDTO reservation) {
        try {
           Reservation reservationS =  reservationService.makeReservation(reservation);
           return new ReservationResponseDTO(reservationS.getId(), true);
        } catch (NoAvailableRoomException e) {
            return new ReservationResponseDTO(-1, false);
        }

    }

    @Path("room_options")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<ReservationOptions> getReservationOptions(){
        return reservationOptionsService.getRoomOptions();
    }

    @Path("cancel_reservation")
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    public Response cancelReservation(@QueryParam("reservationNumber") String reservationNumber)  {
        try {
            return reservationService.cancelReservation(reservationNumber)? Response.noContent().build() : Response.status(Response.Status.BAD_REQUEST).build();
        } catch (NoAvailableReservationException e) {
           return  Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
