package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.ConfirmationPayment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
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
                .to("sjms2:M1.payment" + userName + "?replyTo=M1.paymentReply" + userName)
                .unmarshal().json(ConfirmationPayment.class);

        from("direct:sendToAmex")
                .autoStartup(isRouteEnabled)
                .marshal().json()
                .to("sjms2:M1.Amex" + userName);

        //only for test
        /*
        from("sjms2:queue:payment" + userName)
                .autoStartup(isRouteEnabled)
                .unmarshal().json(InformationPayment.class)
                .process(returnOk())
                .marshal().json();
         */
    }

    //only for test
    /*
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
    */

}
