package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.ConfirmationPayment;
import fr.pantheonsorbonne.ufr27.miage.dto.InformationPayment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.sjms.SjmsMessage;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @ConfigProperty(name = "camel.routes.enabled", defaultValue = "true")
    boolean isRouteEnabled;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @ConfigProperty(name = "quarkus.artemis.username")
    String userName;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {
        camelContext.setTracing(true);

        from("direct:validatePayment")
                .autoStartup(isRouteEnabled)
                .setExchangePattern(ExchangePattern.InOut)
                .marshal().json()
                .to("sjms2:queue:payment" + userName + "?replyTo=paymentReply" + userName)
                .unmarshal().json(ConfirmationPayment.class);

        from("direct:sendToAmex")
                .autoStartup(isRouteEnabled)
                .marshal().json()
                .to("sjms2:queue:Amex" + userName);

        from("sjms2:queue:payment" + userName)
                .autoStartup(isRouteEnabled)
                .unmarshal().json(InformationPayment.class)
                .process(returnOk())
                .marshal().json();
    }
    private Processor returnOk() {
       return exchange -> {
           InformationPayment informationPayment = exchange.getMessage().getBody(InformationPayment.class);
           ConfirmationPayment payment = new ConfirmationPayment();
           payment.setIdTransaction(12345);
           if (informationPayment.getPrice() < 5000) {
               payment.setTransactionStatus(true);
           } else {
               payment.setTransactionStatus(false);
               payment.setErrorMessage("Amount too high");
           }
           Message in = exchange.getIn();
           SjmsMessage response = ((SjmsMessage) in).newInstance();
           response.setHeader("JMSCorrelationID", in.getHeader("JMSCorrelationID"));
           response.setHeader("Content-Type", "application/json");
           response.setBody(payment);
           exchange.setOut(response);
       };
    }

    /*

    @ConfigProperty(name = "camel.routes.enabled", defaultValue = "true")
    boolean isRouteEnabled;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    BookingGateway bookingHandler;

    @Inject
    TicketingService ticketingService;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        onException(ExpiredTransitionalTicketException.class)
                .handled(true)
                .process(new ExpiredTransitionalTicketProcessor())
                .setHeader("success", simple("false"))
                .log("Clearning expired transitional ticket ${body}")
                .bean(ticketingService, "cleanUpTransitionalTicket");

        onException(UnsuficientQuotaForVenueException.class)
                .handled(true)
                .setHeader("success", simple("false"))
                .setBody(simple("Vendor has not enough quota for this venue"));


        onException(NoSuchTicketException.class)
                .handled(true)
                .setHeader("success", simple("false"))
                .setBody(simple("Ticket has expired"));

        onException(CustomerNotFoundException.NoSeatAvailableException.class)
                .handled(true)
                .setHeader("success", simple("false"))
                .setBody(simple("No seat is available"));


        from("sjms2:" + jmsPrefix + "booking?exchangePattern=InOut")//
                .autoStartup(isRouteEnabled)
                .log("ticker received: ${in.headers}")//
                .unmarshal().json(Booking.class)//
                .bean(bookingHandler, "book").marshal().json()
        ;


        from("sjms2:" + jmsPrefix + "ticket?exchangePattern=InOut")
                .autoStartup(isRouteEnabled)
                .unmarshal().json(ETicket.class)
                .bean(ticketingService, "emitTicket").marshal().json();


        from("direct:ticketCancel")
                .autoStartup(isRouteEnabled)
                .marshal().json()
                .to("sjms2:topic:" + jmsPrefix + "cancellation");

    }

    private static class ExpiredTransitionalTicketProcessor implements Processor {
        @Override
        public void process(Exchange exchange) throws Exception {
            //https://camel.apache.org/manual/exception-clause.html
            CamelExecutionException caused = (CamelExecutionException) exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);


            exchange.getMessage().setBody(((ExpiredTransitionalTicketException) caused.getCause()).getExpiredTicketId());
        }
    }

     */
}
