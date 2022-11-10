package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;


@Entity
public class ArtistTour {
    @EmbeddedId
    private ArtistTourId id;

    public ArtistTourId getId() {
        return id;
    }

    public void setId(ArtistTourId id) {
        this.id = id;
    }
}