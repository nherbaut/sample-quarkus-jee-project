package fr.pantheonsorbonne.ufr27.miage.camel;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BankRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    PaymentGateway paymentGateway;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:queue:" + jmsPrefix + "/readyToPay?exchangePattern=InOut")
                .unmarshal().json()
                .bean(paymentGateway, "sendURL");

        from("direct:sendPaidPrice")
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/sendPaidPrice?exchangePattern=InOut");

    }
}
