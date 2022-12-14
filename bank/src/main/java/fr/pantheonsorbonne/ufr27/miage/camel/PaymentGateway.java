package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class PaymentGateway {

    @Inject
    PaymentService paymentService;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext context;

    public String sendURL(Float totalPrice) {
        return paymentService.sendRedirectURL(totalPrice);
    }

    public void sendPaidPrice(Float sendPrice){
        try (ProducerTemplate producer = context.createProducerTemplate()){
            producer.sendBody("direct:sendPaidPrice", sendPrice);
        } catch (IOException e){
            e.printStackTrace();
        }
    }



}
