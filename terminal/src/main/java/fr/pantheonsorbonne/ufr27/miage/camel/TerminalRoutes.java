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
    OrderItemGateway orderItemGateway;

    @Inject
    OrderGateway orderGateway;

    @Inject
    PaymentGateway paymentGateway;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:queue:" + jmsPrefix + "/register?exchangePattern=InOut")
                .unmarshal().json()
                .bean(orderItemGateway, "getItems")
                .marshal().json();


        from("jms:queue:" + jmsPrefix + "/newOrder?exchangePattern=InOut")
                .bean(orderGateway, "createOrder")
                .marshal().json();

        from("jms:queue:" + jmsPrefix + "/addProductInOrder?exchangePattern=InOut")
                .unmarshal().json()
                .bean(orderGateway,"addItemToOrder")
                .marshal().json();

        from("jms:queue:" + jmsPrefix + "/totalPrice?exchangePattern=InOut")
                .unmarshal().json()
                .bean(orderGateway,"getTotalPrice").marshal().json();

        from("jms:queue:" + jmsPrefix + "/deleteProductFromOrder?exchangePattern=InOut")
                .unmarshal().json()
                .bean(orderGateway,"deleteItemOrder")
                .marshal().json();

        from("jms:queue:" + jmsPrefix + "/deleteOrder?exchangePattern=InOut")
                .unmarshal().json()
                .bean(orderGateway, "deleteOrder").marshal().json();

        from("jms:queue:" + jmsPrefix + "/payByCard?exchangePattern=InOut")
                .unmarshal().json()
                .bean(paymentGateway, "isAbleForPayment")
                .marshal().json() // "ok {totalPrice}"
                .to("jms:queue:" + jmsPrefix + "/readyToPay?exchangePattern=InOut")
                //.unmarshal().json()
                .bean(paymentGateway, "receiveURL");

    }

}
