package fr.pantheonsorbonne.ufr27.miage.dao;


import fr.pantheonsorbonne.ufr27.miage.model.Venue;
import fr.pantheonsorbonne.ufr27.miage.model.VenueQuota;

import jakarta.transaction.Transactional;
import java.util.Collection;

public interface VenueQuotaDAO {
    @Transactional
    VenueQuota getQuotaForVendorForVenue(int idVendor, int idVenue);

    Collection<Venue> getQuotaForVendor(int idVendor);

    VenueQuota getMatchingQuota(int vendorId, int venueId, int standing, int seating);
}
