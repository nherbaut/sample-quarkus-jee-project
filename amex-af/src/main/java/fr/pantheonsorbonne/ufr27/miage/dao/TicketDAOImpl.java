package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class TicketDAOImpl implements TicketDAO {
    @PersistenceContext
    EntityManager em;
    @Override
    public Ticket createTicket(int idTicket, int idClient, float montant) {
        Ticket ticket = new Ticket(idTicket, idClient, montant);
        em.persist(ticket);
        return ticket;
    }
}