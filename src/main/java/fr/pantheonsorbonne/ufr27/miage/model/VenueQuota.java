package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;

@Entity
public class VenueQuota {
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

    @OneToOne
    Vendor vendor;


    @OneToOne
    Venue venue;

    Long standingQuota;
    Long seatingQuota;

    public Venue getVenue() {
        return venue;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Long getStandingQuota() {
        return standingQuota;
    }

    public void setStandingQuota(Long standingQuota) {
        this.standingQuota = standingQuota;
    }

    public Long getSeatingQuota() {
        return seatingQuota;
    }

    public void setSeatingQuota(Long seatingQuota) {
        this.seatingQuota = seatingQuota;
    }

    public Vendor getVendor() {
        return vendor;
    }
}
