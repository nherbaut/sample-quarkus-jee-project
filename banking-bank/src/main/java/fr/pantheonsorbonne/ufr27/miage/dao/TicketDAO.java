package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Customer;
import fr.pantheonsorbonne.ufr27.miage.model.Ticket;
import fr.pantheonsorbonne.ufr27.miage.model.Vendor;
import fr.pantheonsorbonne.ufr27.miage.model.Venue;

import java.time.Instant;

public interface TicketDAO {
    Ticket findTicket(int transitionalTicketId) throws NoSuchTicketException;

    Ticket emitTicketForCustomer(int transitionalTickerId, Customer customer);

    void removeTransitionalTicket(int transitionalTicketId);


    Ticket save(Instant plus, Vendor vendor, Venue venue);

    Ticket save(Instant plus, Vendor vendor, Venue venue, String seatReference);
}
