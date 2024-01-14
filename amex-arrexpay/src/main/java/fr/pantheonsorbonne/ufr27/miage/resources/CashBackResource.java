package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.CashbackService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("cashback")
public class CashBackResource {

    Logger logger = LoggerFactory.getLogger(CashBackResource.class);
    @Inject
    CashbackService cashbackService;

    @Path("/{idClient}")
    @GET
    public Response getCashbackAmount(@PathParam("idClient") int idClient) {
        try {
            return Response.ok(cashbackService.getCashbackAmount(idClient)).build();
        } catch (CustomerNotFoundException e) {
            logger.error("Client {} doesn't exist", idClient);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}