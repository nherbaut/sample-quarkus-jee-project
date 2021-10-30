package fr.pantheonsorbonne.ufr27.miage.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeatId implements Serializable {
    private static final long serialVersionUID = -5749899323648160675L;
    @Column(name = "seatReference", nullable = false, length = 45)
    private String seatReference;
    @Column(name = "idVenue", nullable = false)
    private Integer idVenue;

    public Integer getIdVenue() {
        return idVenue;
    }

    public void setIdVenue(Integer idVenue) {
        this.idVenue = idVenue;
    }

    public String getSeatReference() {
        return seatReference;
    }

    public void setSeatReference(String seatReference) {
        this.seatReference = seatReference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatReference, idVenue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SeatId entity = (SeatId) o;
        return Objects.equals(this.seatReference, entity.seatReference) &&
                Objects.equals(this.idVenue, entity.idVenue);
    }
}