package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.TicketValidationDataDTO;
import fr.pantheonsorbonne.ufr27.miage.service.TicketingService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("ticket")
public class TicketResource {


    @Inject
    TicketingService ticketingService;

    @Path(("/validity"))
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response isTicketValid(TicketValidationDataDTO t) {

        if (ticketingService.validateTicket(t.idTicket(), t.idVenue(), t.idVendor(), t.salt(), t.key())) {
            return Response.ok().build();
        } else {
            return Response.status(422, "invalid verification code").build();
        }
    }

}
