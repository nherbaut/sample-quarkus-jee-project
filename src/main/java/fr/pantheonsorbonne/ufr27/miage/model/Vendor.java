package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Vendor {
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

    @OneToMany
    Collection<Ticket> tickets;

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }


    public Collection<VenueQuota> getVenueQuotas() {
        return venueQuotas;
    }

    public void setVenueQuotas(Collection<VenueQuota> venues) {
        this.venueQuotas = venues;
    }

    @OneToMany
    Collection<VenueQuota> venueQuotas;
}
