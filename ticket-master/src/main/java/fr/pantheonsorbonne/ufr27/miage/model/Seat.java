package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;

@Table(name = "Seat", indexes = {
        @Index(name = "fk_Seat_1_idx", columnList = "idVenue")
})
@Entity
public class Seat {
    @EmbeddedId
    private SeatId id;

    @Column(name = "sold", nullable = false)
    private Boolean sold = false;

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public SeatId getId() {
        return id;
    }

    public void setId(SeatId id) {
        this.id = id;
    }
}