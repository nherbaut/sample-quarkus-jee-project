package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    CamelContext camelContext;

    @Inject
    CashbackGateway cashbackGateway;

    @Override
    public void configure() {

        camelContext.setTracing(true);

        //from("file:data/folder")
        from("sjms2:M1.AMEX.toAMEXCashback")
                .unmarshal().json(Cashback.class)
                .bean(cashbackGateway, "cashback")
                .marshal().json()
                .multicast()
                .to("file:data/testFolder","sjms2:M1.AMEX.toAMEXPay");
    }
}
