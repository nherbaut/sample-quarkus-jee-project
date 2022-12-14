package fr.pantheonsorbonne.ufr27.miage.resource;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("order")
@RegisterRestClient(configKey = "vendor-api")
public interface OrderResource {

    @Path("{productId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(@PathParam("productId") Integer productId);

    @Path("{orderId}/product/{productId}")
    @PUT
    public String addProduct(@PathParam("productId") Integer productId, @PathParam("orderId") Integer orderId);

    @Path("{orderId}/product/{productId}")
    @DELETE
    public String deleteProduct(@PathParam("productId") Integer productId, @PathParam("orderId") Integer orderId);

    @Path("{orderId}/")
    @DELETE
    public void deleterOrder(@PathParam("orderId") String orderId);

    @Path("{orderId}/total") //Le client demande à passer au paiement
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getOrderPrice(@PathParam("orderId") Integer orderId);

    @Path("{orderId}/payment/card")
    @GET
    public Response payment(@PathParam("orderId") Integer orderId);

}
