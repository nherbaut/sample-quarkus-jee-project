package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Venue;

public interface VenueDAO {
    Venue findById(int venueId);
}
