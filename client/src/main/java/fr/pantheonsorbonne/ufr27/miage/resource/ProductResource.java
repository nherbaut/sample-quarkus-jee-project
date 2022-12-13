package fr.pantheonsorbonne.ufr27.miage.resource;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("products")
@RegisterRestClient(configKey = "vendor-api")
public interface ProductResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProduct();

}
