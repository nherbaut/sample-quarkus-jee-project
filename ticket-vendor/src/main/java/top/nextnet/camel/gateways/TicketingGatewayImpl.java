package top.nextnet.camel.gateways;

import fr.pantheonsorbonne.ufr27.miage.dto.ETicket;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class TicketingGatewayImpl implements TicketingGateway {

    @Inject
    CamelContext camelContext;

    @Override
    public void submitETicket(ETicket ticket) {
        try (ProducerTemplate template = camelContext.createProducerTemplate()) {
            template.sendBody("direct:ticket", ticket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
