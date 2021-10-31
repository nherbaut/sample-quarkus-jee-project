package fr.pantheonsorbonne.ufr27.miage.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArtistTourId implements Serializable {
    private static final long serialVersionUID = 1018949744063089933L;
    @Column(name = "idArtist", nullable = false)
    private Integer idArtist;
    @Column(name = "idVenue", nullable = false)
    private Integer idVenue;

    public Integer getIdVenue() {
        return idVenue;
    }

    public void setIdVenue(Integer idVenue) {
        this.idVenue = idVenue;
    }

    public Integer getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(Integer idArtist) {
        this.idArtist = idArtist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArtist, idVenue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ArtistTourId entity = (ArtistTourId) o;
        return Objects.equals(this.idArtist, entity.idArtist) &&
                Objects.equals(this.idVenue, entity.idVenue);
    }
}