package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.exception.ExpiredTransitionalTicketException;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    ProductGateway productGateway;

    @Inject
    OrderGateway orderGateway;

    @Inject
    ProductService productService;

    @Inject
    OrderService orderService;

    @Inject
    CamelContext camelContext;



    @Override
    public void configure() throws Exception {


        //from direct queue to JMS où on va envoyer la demande au terminal venant du Gateway

    }

}
