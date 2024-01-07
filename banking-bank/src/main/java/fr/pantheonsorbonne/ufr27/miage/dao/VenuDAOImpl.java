package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Venue;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
@ApplicationScoped
public class VenuDAOImpl implements VenueDAO {

    @Inject
    EntityManager em;

    @Override
    public Venue findById(int venueId) {
        return em.find(Venue.class, venueId);
    }
}
