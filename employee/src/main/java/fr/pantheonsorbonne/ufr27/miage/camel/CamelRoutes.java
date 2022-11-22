package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    //@Inject
    ProductGateway productGateway;

    //@Inject
    OrderGateway orderGateway;
    @Inject
    ProductService productService;

    //@Inject
    OrderService orderService;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {
        //from direct queue to JMS où on va envoyer la demande au terminal venant du Gateway .unmarshallJson() .bean()
        from("direct:newClient")
                .setHeader("newClient", constant("newClient"))
                .to("jms:queue/miage.register");
                //.unmarshal().json()
                //.bean(productService, "getAllProduct");
    }

}
