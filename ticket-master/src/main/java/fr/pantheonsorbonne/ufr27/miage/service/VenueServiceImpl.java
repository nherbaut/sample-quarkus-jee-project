package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Gig;
import fr.pantheonsorbonne.ufr27.miage.dto.RemainingQuota;
import fr.pantheonsorbonne.ufr27.miage.dao.VenueQuotaDAO;
import fr.pantheonsorbonne.ufr27.miage.model.Artist;
import fr.pantheonsorbonne.ufr27.miage.model.Venue;
import fr.pantheonsorbonne.ufr27.miage.model.VenueLineUp;
import fr.pantheonsorbonne.ufr27.miage.model.VenueQuota;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.LinkedList;

@RequestScoped
public class VenueServiceImpl implements VenueService {

    @PersistenceContext
    EntityManager em;

    @Inject
    VenueQuotaDAO venueQuotaDAO;


    @Override
    public RemainingQuota getRemainingQuotaForVendor(int idVendor, int idVenue) {
        VenueQuota quota = venueQuotaDAO.getQuotaForVendorForVenue(idVendor, idVenue);
        return new RemainingQuota(quota.getStandingQuota(), quota.getSeatingQuota());


    }

    @Override
    public Collection<Gig> getAvailableGigs(int idVendor) {
        Collection<Gig> gigs = new LinkedList<>();
        for (Venue venue : venueQuotaDAO.getQuotaForVendor(idVendor)) {
            StringBuilder builder = new StringBuilder();
            for (VenueLineUp lineUp : venue.getLineUp()) {
                builder.append(lineUp.getId().getArtist().getName());
                builder.append(" and ");
            }
            String allArtists = builder.substring(0, builder.length() - 5);
            gigs.add(new Gig(allArtists, venue.getLocation().getName(),venue.getVenueDate(),venue.getId().intValue()));
        }

        return gigs;
    }
}
