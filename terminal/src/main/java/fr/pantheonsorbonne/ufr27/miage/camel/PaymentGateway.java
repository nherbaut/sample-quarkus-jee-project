package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import org.apache.camel.ProducerTemplate;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.io.IOException;
import java.util.stream.Collectors;

@ApplicationScoped
public class PaymentGateway {

    @Inject
    PaymentService paymentService;

    @Inject
    CamelContext context;

    @Inject
    ConnectionFactory connectionFactory;

    public void askPayByCard(Float totalPrice) {
        try (ProducerTemplate producer = context.createProducerTemplate()) {
            producer.sendBody("direct:sendPrice", totalPrice.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receivePrice(Integer orderId) throws OrderNotFoundException {
        paymentService.cardPayment(orderId);
    }

    public void receiveURL(String url) {
        paymentService.receiveURL(url);
    }






}
