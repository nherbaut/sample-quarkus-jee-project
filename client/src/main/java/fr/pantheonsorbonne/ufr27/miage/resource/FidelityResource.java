package fr.pantheonsorbonne.ufr27.miage.resource;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("fidelity")
@RegisterRestClient(configKey = "vendor-api")
public interface FidelityResource {

    @Path("{clientId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response connect(@PathParam("clientId") Integer clientId);

}
