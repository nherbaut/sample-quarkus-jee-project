package fr.pantheonsorbonne.ufr27.miage.resource;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("client")
@RegisterRestClient(configKey = "vendor-api")
public interface EmployeeService {

    @Path("products")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProduct();

    @Path("order/{productId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public OrderDTO createOrder(@PathParam("productId") Integer productId);

    @Path("order/{orderId}/add/{productId}")
    @PUT
    public Response addProduct(@PathParam("productId") Integer productId, @PathParam("orderId") Integer orderId);

    @Path("order/{orderId}/delete/{productId}")
    @DELETE
    public Response deleteProduct(@PathParam("productId") Integer productId, @PathParam("orderId") Integer orderId);

    @Path("order/{orderId}/delete")
    @DELETE
    public void deleterOrder(@PathParam("orderId") String orderId);

    @Path("order/{orderId}/getTotal") //Le client demande à passer au paiement
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getOrderPrice(@PathParam("orderId") Integer orderId);

}
