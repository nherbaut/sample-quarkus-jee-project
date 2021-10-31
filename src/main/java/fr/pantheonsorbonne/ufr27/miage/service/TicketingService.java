package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.ExpiredTransitionalTicketException;
import fr.pantheonsorbonne.ufr27.miage.dto.ETicket;
import fr.pantheonsorbonne.ufr27.miage.model.Ticket;

public interface TicketingService {
    String emitTicker(ETicket eticket) throws ExpiredTransitionalTicketException;

    void cleanUpTransitionalTicket(int transitionalTicketId);

    boolean validateTicket(Ticket t);
}
