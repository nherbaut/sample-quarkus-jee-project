package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.InformationForAmex;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@QuarkusTest
@ExtendWith(MockitoExtension.class)
public class AmexServiceImplTest {

    @Inject
    AmexService amexService;

    @Inject
    CamelContext camelContext;

    @Test
    void shouldSendInformationsToAmex() throws InterruptedException {

        MockEndpoint endpoint = camelContext.getEndpoint("mock:direct:sendToAmex", MockEndpoint.class);
        endpoint.expectedMessageCount(1);
        endpoint.expectedBodiesReceived(new InformationForAmex(123, 456));

        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        InformationForAmex informationForAmex = new InformationForAmex(123, 456);
        producerTemplate.sendBody(endpoint, informationForAmex);

        endpoint.assertIsSatisfied();
    }
}
