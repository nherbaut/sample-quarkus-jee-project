package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.Product;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Collection;

@ApplicationScoped
public class ProductGateway {

    @Inject
    OrderService orderService;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext context;
    public Collection<Product> getAllProduct(){
        try (ProducerTemplate producer = context.createProducerTemplate()){
            producer.sendBody("direct:newClient", "clientArrived");
        } catch (IOException e){
            e.printStackTrace();
        }
        //envoyer dans une route le message au terminal pour lui dire qu'on veut la liste des products
        return null;
    }
}
