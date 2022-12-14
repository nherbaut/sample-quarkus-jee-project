package fr.pantheonsorbonne.ufr27.miage.resources;


import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;
import org.hibernate.criterion.Order;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("order")
public class OrderResource {
    
    @Inject
    OrderService orderService;

    @Inject
    PaymentService paymentService;

    @Path("{productId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@PathParam("productId") Integer productId) {
        //Créer la commande
        //Ajouter l'article en paramètre, update prix etc..
        //Retourner l'id de la commande
        // TODO faire en sorte d'afficher la commande comme on affiche les produits omg
        try {
            return Response.created(URI.create("order/"+orderService.createOrder(productId).getOrderId())).build();
        } catch (ProductNotFoundException e) {
            throw new WebApplicationException(502);
        }
    }

    @Path("{orderId}/product/{productId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@PathParam("productId") Integer productId, @PathParam("orderId") Integer orderId){
        //Récupére l'order de la bdd du terminal ?
        //Ajouter le produit, update prix etc..
        return Response.ok(orderService.addProduct(productId,orderId)).build();
    }

    @Path("{orderId}/product/{productId}")
    @DELETE
    public Response deleteProduct(@PathParam("productId") Integer productId, @PathParam("orderId") Integer orderId){
        //Récupére l'order de la mémoire locale du terminal
        //Supprimer le produit, update prix etc..
        return Response.ok(orderService.deleteProduct(orderId, productId)).build();
    }

    @Path("{orderId}/")
    @DELETE
    public void deleterOrder(@PathParam("orderId") Integer orderId) {
        //Delete order in terminal
        try {
            orderService.deleteOrder(orderId);
        } catch (OrderNotFoundException e) {
            throw new WebApplicationException(404);
        }
    }

    @Path("{orderId}/total") //Le client demande à passer au paiement
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getOrderPrice(@PathParam("orderId") Integer orderId) throws OrderNotFoundException {
        //Récupérer la commande
        //renvoyer le prix
        return Response.ok(orderService.getTotalPrice(orderId)).build();
    }

    @Path("{orderId}/payment/card")
    @GET
    public Response payment(@PathParam("orderId") Integer orderId) throws OrderNotFoundException{
        return Response.temporaryRedirect(URI.create(paymentService.payByCard(orderId))).build();
    }

}
