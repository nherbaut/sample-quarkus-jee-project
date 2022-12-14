package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.ClientDTO;
import fr.pantheonsorbonne.ufr27.miage.service.FidelityService;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class FidelityGateway {

    @Inject
    CamelContext camelContext;

    @Inject
    FidelityService fidelityService;

    public void askConnection(Integer clientId){
        try (ProducerTemplate producer = camelContext.createProducerTemplate()){
            producer.sendBody("direct:connection",clientId);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setClient(ClientDTO client){
        fidelityService.receiveClient(client);
    }

}
