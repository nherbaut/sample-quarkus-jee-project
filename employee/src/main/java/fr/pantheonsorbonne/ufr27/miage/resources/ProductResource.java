package fr.pantheonsorbonne.ufr27.miage.resources;


import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("products")
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProduct(){
        //Employee ask terminal for product list
        //Terminal sends product list
        //Employee returns product list to client
        return Response.ok(productService.getAllProduct()).build();
    }

}
