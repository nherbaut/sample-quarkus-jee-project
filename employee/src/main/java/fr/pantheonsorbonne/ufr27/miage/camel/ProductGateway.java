package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTOContainer;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class ProductGateway {

    @Inject
    OrderService orderService;

    @Inject
    ProductService productService;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext context;

    public void askAllProduct(){
        try (ProducerTemplate producer = context.createProducerTemplate()){
            producer.sendBody("direct:newClient", "clientArrived");
        } catch (IOException e){
            e.printStackTrace();
        }
        //envoyer dans une route le message au terminal pour lui dire qu'on veut la liste des products
    }

    public void receiveAllProduct(OrderItemDTOContainer productDTOContainer){
        productService.receiveAllProduct(productDTOContainer);
    }
}
