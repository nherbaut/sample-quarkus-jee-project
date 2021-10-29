package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatReference() {
        return seatReference;
    }

    public void setSeatReference(String seatReference) {
        this.seatReference = seatReference;
    }

    private String seatReference;


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToOne
    private Location location;

}
