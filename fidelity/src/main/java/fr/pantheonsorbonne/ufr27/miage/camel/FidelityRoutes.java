package fr.pantheonsorbonne.ufr27.miage.camel;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FidelityRoutes extends RouteBuilder {

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext camelContext;

    @Inject
    FidelityGateway fidelityGateway;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:queue:" + jmsPrefix + "/fidelityPointsFeat?exchangePattern=InOut")
                .unmarshal().json()
                .bean(fidelityGateway, "getTotalPoints")
                .marshal().json();

        from("jms:queue:" + jmsPrefix + "/addFidelityPointsFeat?exchangePattern=InOut")
                .bean(fidelityGateway, "addPointsToAccount")
                .marshal().json();

        from("jms:queue:" + jmsPrefix + "/fidelityFeat?exchangePattern=InOut")
                .unmarshal().json()
                .bean(fidelityGateway, "verifyAccount")
                .log("${in.body}")
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "clientConnected?exchangePattern=InOnly");

    }




}
