package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.model.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class DBPopulation {
    public EntityManager getEm() {
        return em;
    }

    @Inject
    EntityManager em;


    @Transactional
    public void truncateAllTables() {
        // Disable referential integrity for H2
        em.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();

        // Query to find all tables
        List<String> tableNames = em.createNativeQuery(
                "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES " +
                        "WHERE TABLE_SCHEMA='PUBLIC'").getResultList();

        // Truncate each table
        for (String tableName : tableNames) {
            em.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
        }

        // Re-enable referential integrity for H2
        em.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }
    @Transactional
    public TestData createMaterial() {

        Location location = new Location();
        location.setName("Le Zenith");
        location.setStandingGauge(1000);
        em.persist(location);

        Artist radiohead = new Artist();
        radiohead.setName("radiohead");
        em.persist(radiohead);

        Venue venue = new Venue();
        venue.setVenueDate(LocalDate.now());
        venue.setLocation(location);

        em.persist(venue);

        VenueLineUpId venueLineUpId = new VenueLineUpId();
        venueLineUpId.setArtist(radiohead);
        venueLineUpId.setIdVenue(venue.getId());

        VenueLineUp lineUp = new VenueLineUp();
        lineUp.setShowTime("21:00");
        lineUp.setId(venueLineUpId);
        em.persist(lineUp);

        venue.getLineUp().add(lineUp);

        Vendor vendor = new Vendor();
        vendor.setName("fnac");
        em.persist(vendor);

        VenueQuotaId venueQuotaId = new VenueQuotaId();
        venueQuotaId.setVenue(venue);
        venueQuotaId.setVendor(vendor);

        VenueQuota quota = new VenueQuota();
        quota.setSeatingQuota(20);
        quota.setStandingQuota(10);
        quota.setId(venueQuotaId);
        em.persist(quota);

        return new TestData(location,  radiohead,  venue, lineUp,  vendor, quota);

    }


}
