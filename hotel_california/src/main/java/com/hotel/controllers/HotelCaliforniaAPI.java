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
import fr.pantheonsorbonne.ufr27.miage.dto.UpdateReservationDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@Path("/hotel")
public class HotelCaliforniaAPI {
    @Inject
    RoomService roomService;
    @Inject
    ReservationDAOImpl reservationService;
    @Inject
    ReservationOptionsService reservationOptionsService;
    @ConfigProperty(name = "hotel.name")
    String hotelName;

    @Path("rooms")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AvailabilityDTO> getAllRooms(){
        return roomService.getRooms();
    }

    @Path("make_reservation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public ReservationResponseDTO makeReservation(ReservationRequestDTO reservation) {
        try {
           Reservation reservationS =  reservationService.makeReservation(reservation);
           return new ReservationResponseDTO(reservationS.getId(), true, reservationS.getTotalPrice(), hotelName, reservationS.getBookingReservationId());
        } catch (NoAvailableRoomException e) {
            return new ReservationResponseDTO(-1, false, 0.0, hotelName, "Reservation failed");
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
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public UpdateReservationDTO cancelReservation(@QueryParam("reservationNumber") String reservationNumber)  {
        try {
            return reservationService.cancelReservation(reservationNumber);
        } catch (NoAvailableReservationException e) {
            return new UpdateReservationDTO(reservationNumber, "Reservation not found");        }
    }

    @Path("update_reservation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public UpdateReservationDTO updateReservation(@QueryParam("reservationStatus") String reservationStatus, @QueryParam("reservationNumber") String reservationNumber)  {
        try {
            return reservationService.changeReservationStatus(reservationStatus, reservationNumber);
        } catch (NoAvailableReservationException e) {
            return new UpdateReservationDTO(reservationNumber, "Reservation not found");
        }
    }
}
