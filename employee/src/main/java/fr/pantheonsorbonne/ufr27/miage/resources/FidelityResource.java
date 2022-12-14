package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.service.FidelityService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("fidelity")
public class FidelityResource {

    @Inject
    FidelityService fidelityService;

    @Path("{clientId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response connect(@PathParam("clientId") Integer clientId){
        return Response.ok(fidelityService.connection(clientId)).build();
    }

}
