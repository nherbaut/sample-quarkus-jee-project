package fr.pantheonsorbonne.ufr27.miage.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VenueLineUpId implements Serializable {
    private static final long serialVersionUID = -879274964975792491L;

    @Column(name = "idVenue", nullable = false)
    private Integer idVenue;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @ManyToOne
    private Artist artist;


    public Integer getIdVenue() {
        return idVenue;
    }

    public void setIdVenue(Integer idVenue) {
        this.idVenue = idVenue;
    }
}