package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Client;
import fr.pantheonsorbonne.ufr27.miage.dto.InformationForAmex;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static fr.pantheonsorbonne.ufr27.miage.dto.Genre.HOMME;


@QuarkusTest
@ExtendWith(MockitoExtension.class)
public class AmexServiceImplTest {

    @Inject
    AmexService amexService;

    @Inject
    CamelContext camelContext;

    @Test
    void shouldSendInformationsToAmex() throws InterruptedException {
        Client client = new Client(123, "homme", 26, "Ingénieur");

        MockEndpoint endpoint = camelContext.getEndpoint("mock:direct:sendToAmex", MockEndpoint.class);
        endpoint.expectedMessageCount(1);
        endpoint.expectedBodiesReceived(new InformationForAmex(client, 456));

        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        InformationForAmex informationForAmex = new InformationForAmex(client, 456);
        producerTemplate.sendBody(endpoint, informationForAmex);

        endpoint.assertIsSatisfied();
    }
}
