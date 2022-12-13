package fr.pantheonsorbonne.ufr27.miage.resources;


import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("payment")
public class PaymentResource {

    @Inject
    PaymentService paymentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getURL(String url){

        return null;
    }

    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPassword(Integer clientId){
        return Response.ok(paymentService.getCardPassword(clientId)).build();
    }

}
