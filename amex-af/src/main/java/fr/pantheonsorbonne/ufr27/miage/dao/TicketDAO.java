package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Ticket;

public interface TicketDAO {

    Ticket createTicket(int idTicket, int idClient, float montant);
}