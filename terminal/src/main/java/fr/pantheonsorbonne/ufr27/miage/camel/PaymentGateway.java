package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.*;
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

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    public Float isAbleForPayment(Integer orderId) throws OrderNotFoundException {
        return paymentService.isAbleForPayment(orderId);
    }

    public void receiveURL(String url){
        paymentService.receiveURL(url);
    }

}
