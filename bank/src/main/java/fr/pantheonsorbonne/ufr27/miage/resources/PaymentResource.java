package fr.pantheonsorbonne.ufr27.miage.resources;


import fr.pantheonsorbonne.ufr27.miage.exception.ClientNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.PasswordIncorrectException;
import fr.pantheonsorbonne.ufr27.miage.exception.SoldUnsifficientException;
import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("payment")
public class PaymentResource {

    @Inject
    PaymentService paymentService;

    @Path("client/{clientId}/password/{password}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cardPayment(@PathParam("clientId") Integer clientId, @PathParam("password") Integer password) throws ClientNotFoundException, SoldUnsifficientException, PasswordIncorrectException {
        return Response.ok(paymentService.cardPayment(clientId,password)).build();
    }

}
