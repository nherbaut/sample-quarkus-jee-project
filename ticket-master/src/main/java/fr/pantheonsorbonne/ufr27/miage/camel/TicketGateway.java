package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.ETicket;
import fr.pantheonsorbonne.ufr27.miage.exception.ExpiredTransitionalTicketException;
import fr.pantheonsorbonne.ufr27.miage.service.TicketingService;
import org.apache.camel.Handler;

import javax.inject.Inject;

public class TicketGateway {

    @Inject
    TicketingService ticketingService;

    @Handler
    void emitTicket(ETicket eticket) {
        try {
            ticketingService.emitTicker(eticket);
        } catch (ExpiredTransitionalTicketException e) {
            ticketingService.cleanUpTransitionalTicket(eticket.getTransitionalTicketId());
        }
    }
}
