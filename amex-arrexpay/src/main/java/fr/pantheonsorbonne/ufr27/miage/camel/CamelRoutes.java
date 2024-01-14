package fr.pantheonsorbonne.ufr27.miage.camel;


import io.vertx.core.json.JsonObject;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("sjms2:M1.AMEX.AskTaux?exchangePattern=InOut")
                .process(exchange -> {
                    Map<String, Object> jsonOutput = new HashMap<>();
                    jsonOutput.put("tauxCashback", 15);
                    jsonOutput.put("idTransaction", 1);
                    jsonOutput.put("idClient", 2);
                    exchange.getIn().setBody(jsonOutput);
                })
                .marshal().json();

    }
}
