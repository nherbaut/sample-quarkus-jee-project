package top.nextnet;

import org.apache.camel.CamelContext;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@ApplicationScoped
public class TicketingService {

    @Inject
    ECommerce ihm;

    @Inject
    CamelContext context;

    @Inject
    TicketingGateway ticketingGateway;


    public Collection<ETicket> initiateTicketing(Collection<ETicket> tickets) {
        ihm.showSuccessMessage("Venue Booked, please provide customer information for ticketing");

        String fname = ihm.getCustomerFirstName();
        String lname = ihm.getCustomerLastName();
        String email = ihm.getCustomerEmail();

        for (ETicket ticket : tickets) {
            ticket.setEmail(email);
            ticket.setFname(fname);
            ticket.setLname(lname);
        }

        return tickets;
    }

    public void onTicketCreated(String ticketKey) {
        ihm.showSuccessMessage("Ticket emited with key" + ticketKey);
    }
}
