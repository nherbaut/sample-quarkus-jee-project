package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import fr.pantheonsorbonne.ufr27.miage.camel.ClientGateway;

import java.util.LinkedHashMap;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {
    @Inject
    CamelContext camelContext;

    @Inject
    ClientGateway clientGateway;


    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        //from("sjms2:M1.AMEX.clientsmkt")
        from("sjms2:M1.AMEX.clientsmkt")
                .unmarshal().json(JsonLibrary.Jackson, LinkedHashMap.class)
                .process(exchange -> {
                    LinkedHashMap<String, Object> jsonMap = exchange.getIn().getBody(LinkedHashMap.class);
                    Client client = new Client();
                    client.setIdClient((Integer) jsonMap.get("idClient"));
                    client.setAge((int) jsonMap.get("age"));
                    client.setProfession((String) jsonMap.get("profession"));
                    client.setGenre((String) jsonMap.get("genre"));
                    clientGateway.client(client);
                });


    }
}