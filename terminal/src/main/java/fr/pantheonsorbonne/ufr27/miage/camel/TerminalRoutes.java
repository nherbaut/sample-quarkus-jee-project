package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.ClientDTO;
import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

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

    @Inject
    FidelityGateway fidelityGateway;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:queue:" + jmsPrefix + "/orderItemFeat?exchangePattern=InOut")
                .unmarshal().json()
                .bean(orderItemGateway, "getItems")
                .marshal().json();


        from("jms:queue:" + jmsPrefix + "/orderFeat?exchangePattern=InOut")
                .unmarshal().json()
                .choice()
                    .when(header("Action").isEqualTo("createOrderAndAddProduct"))
                        .bean(orderGateway, "createOrder")
                        .marshal().json().stop()
                    .when(header("Action").isEqualTo("addProduct"))
                        .bean(orderGateway,"addItemToOrder")
                        .marshal().json().stop()
                    .when(header("Action").isEqualTo("deleteProductOrder"))
                        .bean(orderGateway,"deleteItemOrder")
                        .marshal().json().stop()
                    .when(header("Action").isEqualTo("getTotalPrice"))
                        .bean(orderGateway,"getTotalPrice")
                        .marshal().json().stop()
                    .when(header("Action").isEqualTo("deleteOrder"))
                        .bean(orderGateway, "deleteOrder")
                        .marshal().json();


        from("jms:queue:" + jmsPrefix + "/paymentFeat?exchangePattern=InOut")
                .unmarshal().json()
                .bean(paymentGateway, "isAbleForPayment")
                .log("${in.body}")
                .marshal().json() // "ok {totalPrice}"
                .to("jms:queue:" + jmsPrefix + "/readyToPay?exchangePattern=InOut")
                //.unmarshal().json()
                .bean(paymentGateway, "receiveURL");

        // TODO set the clientId
        from("jms:queue:" + jmsPrefix + "clientConnected")
                .unmarshal().json(ClientDTO.class)
                .log("${in.body}")
                .bean(fidelityGateway, "setClientId");


        from("jms:queue:" + jmsPrefix + "/sendPaidPrice?exchangePattern=InOut")
                .log("Here is the payment success ${in.body}")
                .toD("jms:queue:" + jmsPrefix + "/paymentDone?exchangePattern=InOut");

    }



}
