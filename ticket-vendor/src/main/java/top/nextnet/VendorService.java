package top.nextnet;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Set;


@Path("/vendor")
@RegisterRestClient(configKey = "vendor-api")
public interface VendorService {


    @Path("{idVendor}/venue/{idVenue}/quota")
    @GET
    RemainingQuota getQuotas(@PathParam int idVendor, @PathParam int idVenue);

    @Path("{idVendor}/venues")
    @GET
    Collection<Gig> getGigs(@PathParam int idVendor);
}
