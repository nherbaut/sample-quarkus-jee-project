package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TerminalRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext camelContext;

    @Inject
    ProductGateway productGateway;

    @Inject
    OrderGateway orderGateway;

    @Inject
    OrderService orderService;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:queue:" + jmsPrefix + "/register?exchangePattern=InOut")
                .unmarshal().json()
                .log("## ${in.body}")
                .bean(productGateway, "getProducts")

                .log("### ${in.body}")

                .marshal().json();


        from("jms:queue:" + jmsPrefix + "/sqdqsd?exchangePattern=InOut")
                .unmarshal().json()
                .log("## ${in.body}azeazeaze")
                .bean(orderService, "creatOrder")

                .log("### ${in.body}finished")

                .marshal().json();


        //Faire en sorte d'appeler productService.getProductList et envoyer la réponse dans la queue
        //.to("jms:queue/miage.register");

        /*
        from("direct:productContent")
                .marshal().json()
                .to("file:data/msgSend");
         */
    }

}