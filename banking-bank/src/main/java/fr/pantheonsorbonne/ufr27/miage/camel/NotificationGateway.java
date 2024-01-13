package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.DemandeAuthorisation;
import fr.pantheonsorbonne.ufr27.miage.model.Notification;
import fr.pantheonsorbonne.ufr27.miage.service.NotificationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;

@ApplicationScoped
public class NotificationGateway {
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;
    @Inject
    NotificationService notificationService;
    @Inject
    CamelContext camelContext;

    public void sendResponseSynchro(String response, Notification n){
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            if(response == "Yes"){
                producerTemplate.sendBodyAndHeader("direct:responseSynchro", "Authorization accepted ! token generated", "success","true");
                //here we can send the token to bankin, also all information related to the customer now
            }else{
                producerTemplate.sendBodyAndHeader("direct:responseSynchro","Authorization refused","success","false");
            }
            notificationService.updateNotificationHandle(n.getIdNotification());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
