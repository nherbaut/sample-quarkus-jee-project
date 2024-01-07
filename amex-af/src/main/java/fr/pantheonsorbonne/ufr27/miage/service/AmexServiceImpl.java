package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.InformationForAmex;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@RequestScoped
public class AmexServiceImpl implements AmexService{

    @Inject
    CamelContext camelContext;

    private static Logger log = LoggerFactory.getLogger(AmexServiceImpl.class);
    @Override
    public void sendInformationPayment(int idClient, float price) {
        //send jms message to amex
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            InformationForAmex informationForAmex = new InformationForAmex(idClient, price);
            producerTemplate.sendBody("direct:sendToAmex",informationForAmex);
        } catch (Exception e) {
            //catch all exception to always return a response to the client, even if sending message to amex fails
            log.error("Error while sending message to Amex", e);
        }
    }
}
