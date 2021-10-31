package top.nextnet;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    BookingResponseHandler BookingResponseHandler;

    @Inject
    TicketingService ticketingService;

    @Inject
    ECommerce eCommerce;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {
        camelContext.setTracing(true);
        from("direct:cli")//
                .marshal().json()//
                .to("jms:" + jmsPrefix + "booking?exchangePattern=InOut")//
                .unmarshal().json(Booking.class)
                .bean(BookingResponseHandler, "onBookedResponseReceived")
                .log("response received ${in.body}")
                .choice()
                .when(header("success").isEqualTo(false))
                .setBody(simple("not enough quota for this vendor"))
                .bean(eCommerce, "showErrorMessage")
                .otherwise()
                .bean(ticketingService, "initiateTicketing")
                .split(body())
                .marshal().json(ETicket.class)
                .log("${body}")
                .to("jms:" + jmsPrefix + "ticket?exchangePattern=InOut")
                .multicast()
                .bean(ticketingService, "onTicketCreated")
                .to("file:data/tickets");


    }
}
