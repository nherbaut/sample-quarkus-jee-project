package top.nextnet.service;

import fr.pantheonsorbonne.ufr27.miage.dto.ETicket;
import fr.pantheonsorbonne.ufr27.miage.dto.TicketEmissionData;

import java.util.Collection;

public interface TicketingService {
    Collection<ETicket> fillTicketsWithCustomerInformations(Collection<ETicket> tickets);

    void notifyCreatedTicket(TicketEmissionData ticketEmissionData);
}
