package fr.pantheonsorbonne.ufr27.miage.resources;


import fr.pantheonsorbonne.ufr27.miage.dto.NewCustomer;
import fr.pantheonsorbonne.ufr27.miage.dto.User;
import fr.pantheonsorbonne.ufr27.miage.service.CompteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.Collection;

@Path("compte")
public class CompteResource {
    @Inject
    CompteService compteService;

    @Path("login")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response login(User user) {
        if (!compteService.login(user.getEmail(), user.getpwd())) {
            return Response.status(401, "invalid login/password").build();
        } else {
            return Response.ok().build();
        }
    }
    @Path("subscription")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response subscription(NewCustomer newCustomer) {
        if(newCustomer.address().equals(null) || newCustomer.pwd().equals(null) ||
        newCustomer.fName().equals(null) || newCustomer.lName().equals(null) ||
        newCustomer.email().equals(null)){
            return Response.status(401, "invalid information").build();
        }
        else{
            compteService.createAccount(newCustomer.fName(), newCustomer.lName(), newCustomer.address(), newCustomer.email(), newCustomer.pwd());
            return Response.ok().build();
        }
    }
}
