package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class OrderGateway {

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext camelContext;

    public void askCreateOrder(Integer productId){
        try (ProducerTemplate producer = camelContext.createProducerTemplate()){
            producer.sendBody("direct:newOrder",productId.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
        //envoyer dans une route le message au terminal pour lui dire qu'on veut la liste des products
    }

}
