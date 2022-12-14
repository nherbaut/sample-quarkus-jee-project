package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.ClientDTO;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;

@ApplicationScoped
public class FidelityGateway {


    @Inject
    OrderService orderService;

    @Inject
    CamelContext context;

    @Inject
    ConnectionFactory connectionFactory;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Handler
    void setClientId(ClientDTO client){
        orderService.setClient(client.getClient_id());
    }


}
