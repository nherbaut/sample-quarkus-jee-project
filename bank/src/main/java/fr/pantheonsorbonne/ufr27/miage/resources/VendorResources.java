package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.Gig;
import fr.pantheonsorbonne.ufr27.miage.dto.RemainingQuota;
import fr.pantheonsorbonne.ufr27.miage.service.VenueService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/vendor")
public class VendorResources {

    @Inject
    protected VenueService service;

    @Path("{idVendor}/venue/{idVenue}/quota")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RemainingQuota getQuotas(@PathParam("idVendor") int idVendor, @PathParam("idVenue") int idVenue) {
        return service.getRemainingQuotaForVendor(idVendor, idVenue);
    }

    @Path("{idVendor}/venues")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Gig> getGigs(@PathParam("idVendor") int idVendor) {
        return service.getAvailableGigs(idVendor);
    }
}