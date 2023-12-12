package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.dao.*;
import fr.pantheonsorbonne.ufr27.miage.dto.Booking;
import fr.pantheonsorbonne.ufr27.miage.exception.UnsuficientQuotaForVenueException;
import fr.pantheonsorbonne.ufr27.miage.model.Ticket;
import fr.pantheonsorbonne.ufr27.miage.model.Vendor;
import fr.pantheonsorbonne.ufr27.miage.model.Venue;
import fr.pantheonsorbonne.ufr27.miage.model.VenueQuota;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class BookingServiceImpl implements BookingService {

    @Inject
    VenueQuotaDAO venueQuotaDAO;
    @Inject
    VenueDAO venueDAO;
    @Inject
    VendorDAO vendorDAO;
    @Inject
    TicketDAO ticketDAO;

    @Override
    @Transactional
    public Booking book(Booking booking) throws UnsuficientQuotaForVenueException {
        try {
            VenueQuota vq = venueQuotaDAO.getMatchingQuota(booking.getVendorId(), booking.getVenueId(), booking.getStandingTicketsNumber(), booking.getSeatingTicketsNumber());
            vq.setSeatingQuota(vq.getSeatingQuota() - booking.getSeatingTicketsNumber());
            vq.setStandingQuota(vq.getStandingQuota() - booking.getStandingTicketsNumber());

            Venue venue = venueDAO.findById(booking.getVenueId());
            Vendor vendor = vendorDAO.findById(booking.getVendorId());


            for (int i = 0; i < booking.getStandingTicketsNumber(); i++) {
                Ticket ticket = ticketDAO.save(Instant.now().plus(10, ChronoUnit.HOURS), vendor, venue);
                booking.getStandingTransitionalTicket().add(ticket.getId());
            }

            for (int i = 0; i < booking.getSeatingTicketsNumber(); i++) {
                Ticket ticket = ticketDAO.save(Instant.now().plus(10, ChronoUnit.MINUTES), vendor, venue);
                booking.getSeatingTransitionalTicket().add(ticket.getId());
            }
        } catch (NonUniqueResultException | NoResultException e) {
            throw new UnsuficientQuotaForVenueException(booking.getVenueId());
        }
        return booking;
    }
}
