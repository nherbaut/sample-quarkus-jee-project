package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.ClientDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTOContainer;
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
    ProductGateway productGateway;

    @Inject
    OrderGateway orderGateway;

    @Inject
    PaymentGateway paymentGateway;

    @Inject
    FidelityGateway fidelityGateway;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {
        camelContext.setTracing(true);
        //from direct queue to JMS où on va envoyer la demande au terminal venant du Gateway .unmarshallJson() .bean()
        from("direct:newClient")
                .setHeader("Action", constant("displayItems"))
                .marshal().json()
                .log("${in.body}")
                .to("jms:queue:" + jmsPrefix + "/orderItemFeat?exchangePattern=InOut")
                .unmarshal().json(OrderItemDTOContainer.class)
                .bean(productGateway, "receiveAllProduct");

        from("direct:newOrder")
                .setHeader("Action", constant("createOrderAndAddProduct"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/orderFeat?exchangePattern=InOut")
                .unmarshal().json(OrderDTO.class)
                .bean(orderGateway, "receiveOrder");

        from(  "direct:addProductInOrder")
                .setHeader("Action", constant("addProduct"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/orderFeat?exchangePattern=InOut")
                .unmarshal().json(OrderDTO.class)
                .bean(orderGateway, "receiveOrder");

        from("direct:getTotalPrice")
                .setHeader("Action",constant("getTotalPrice"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/orderFeat?exchangePattern=InOut")
                .unmarshal().json()
                .bean(orderGateway,"recieveTotalPrice");

        from(  "direct:deleteProductFromOrder")
                .setHeader("Action", constant("deleteProductOrder"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/orderFeat?exchangePattern=InOut")
                .unmarshal().json(OrderDTO.class)
                .bean(orderGateway, "receiveOrder");

        from("direct:deleteOrder")
                .setHeader("Action", constant("deleteOrder"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/orderFeat?exchangePattern=InOut");

        from("direct:payByCard")
                .setHeader("Action", constant("payByCard"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/paymentFeat?exchangePattern=InOut")
                .bean(paymentGateway, "receiveURL");

        from("direct:connection")
                .setHeader("Action", constant("connection"))
                .marshal().json()
                .to("jms:queue:" + jmsPrefix + "/fidelityFeat?exchangePattern=InOut")
                .unmarshal().json(ClientDTO.class)
                .bean(fidelityGateway, "setClient");
                
        from("jms:queue:" + jmsPrefix + "/paymentDone?exchangePattern=InOut")
                .unmarshal().json()
                .log("Here is the payment success ${in.body}");

    }

}
