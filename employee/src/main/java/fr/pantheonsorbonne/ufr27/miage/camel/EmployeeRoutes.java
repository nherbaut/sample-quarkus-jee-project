package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTOContainer;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class EmployeeRoutes extends RouteBuilder {

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    ProductService productService;

    @Inject
    ProductGateway productGateway;

    @Inject
    OrderGateway orderGateway;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {
        camelContext.setTracing(true);
        //from direct queue to JMS où on va envoyer la demande au terminal venant du Gateway .unmarshallJson() .bean()
        from("direct:newClient")
                .setHeader("newClient", constant("newClient"))
                .marshal().json()
                .log("${in.body}")
                .to("jms:queue:" + jmsPrefix + "/register?exchangePattern=InOut")
                .unmarshal().json(ProductDTOContainer.class)
                .bean(productGateway, "receiveAllProduct");


        from("direct:newOrder")
                .setHeader("newOrder", constant("newOrder"))
                .to("jms:queue:" + jmsPrefix + "/newOrder?exchangePattern=InOut");

        from(  "direct:addProductInOrder")
                .setHeader("addProductOrder", constant("addProductOrder"))
                .marshal().json()
               .to("jms:queue:" + jmsPrefix + "/addProductInOrder?exchangePattern=InOut");

        from("direct:getTotalPrice")
                .setHeader("getTotalPrice",constant("totalPrice"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/totalPrice?exchangePattern=InOut")
                .unmarshal().json()
                .bean(orderGateway,"recieveTotalPrice");


        from(  "direct:deleteProductFromOrder")
                .setHeader("deleteProductOrder", constant("deleteProductOrder"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/deleteProductFromOrder?exchangePattern=InOut");


        from("direct:deleteOrder")
                .setHeader("deleteOrder", constant("deleteOrder"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/deleteOrder?exchangePattern=InOut");
    }

}
