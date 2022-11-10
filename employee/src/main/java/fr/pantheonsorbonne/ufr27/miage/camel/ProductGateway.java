package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import org.apache.camel.CamelContext;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;

public class ProductGateway {

    @Inject
    OrderService orderService;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext camelContext;

    public void getAllProduct(){
        //envoyer dans une route le message au terminal pour lui dire qu'on veut la liste des products
    }

}
