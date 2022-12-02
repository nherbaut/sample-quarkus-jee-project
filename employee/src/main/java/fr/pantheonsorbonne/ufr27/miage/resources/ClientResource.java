package fr.pantheonsorbonne.ufr27.miage.resources;


import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("client")
public class ClientResource {

    @Inject
    ProductService productService;
    @Inject
    OrderService orderService;

    @Path("products")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProduct(){
        //Employee ask terminal for product list
        //Terminal sends product list
        //Employee returns product list to client

        return Response.ok(productService.getAllProduct()).build();
    }

    @Path("order/{productId}")
    @POST
    public Response createOrder(@PathParam("productId") Integer productId){
        //Créer la commande
        //Ajouter l'article en paramètre, update prix etc..
        //Retourner l'id de la commande
        return Response.ok(orderService.createOrder(productId)).build();
    }

    @Path("order/{orderId}/add/{productId}")
    @PUT
    public Response addProduct(@PathParam("productId") Integer productId, @PathParam("orderId") Integer orderId){
        //Récupére l'order de la bdd du terminal ?
        //Ajouter le produit, update prix etc..
        return Response.ok(orderService.addProduct(productId,orderId)).build();
    }

    @Path("order/{orderId}/delete/{productId}")
    @DELETE
    public Response deleteProduct(@PathParam("productId") String productId, @PathParam("orderId") String orderId){
        //Récupére l'order de la mémoire locale du terminal
        //Supprimer le produit, update prix etc..
        return null;
    }

    @Path("order/{orderId}/delete")
    @DELETE
    public void deleterOrder(@PathParam("orderId") String orderId){
        //Delete order in terminal
        Integer id = Integer.parseInt(orderId);
        orderService.deleteOrder(id);
    }

    @Path("order/{orderId}/getTotal") //Le client demande à passer au paiement
    @GET
    public Response getTotalPrice(@PathParam("orderId") String orderId){
        //Récupérer la commande
        //renvoyer le prix
        return null;
    }

}
