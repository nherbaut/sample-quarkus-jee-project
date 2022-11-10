package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.service.VenueService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("artist")
public class ArtistResource {

    @Inject
    VenueService venueService;

    @Path("{artistId}/venue/{venueId}")
    @DELETE
    public void cancelVenue(@PathParam("artistId") int artistId, @PathParam("venueId") int venueId) {
        venueService.cancelVenueForArtist(artistId, venueId);
    }
}
