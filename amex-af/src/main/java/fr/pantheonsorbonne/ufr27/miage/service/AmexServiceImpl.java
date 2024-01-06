package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.InformationForAmex;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import java.io.IOException;

@RequestScoped
public class AmexServiceImpl implements AmexService{

    @Inject
    CamelContext camelContext;
    @Override
    public void sendInformationPayment(int idClient, float price) {
        //send jms message to amex
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            InformationForAmex informationForAmex = new InformationForAmex(idClient, price);
            producerTemplate.sendBody("direct:sendToAmex",informationForAmex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
