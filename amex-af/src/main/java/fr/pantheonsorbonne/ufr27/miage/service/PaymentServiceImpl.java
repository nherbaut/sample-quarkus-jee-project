package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.CancelationNotice;
import fr.pantheonsorbonne.ufr27.miage.dto.ConfirmationPayment;
import fr.pantheonsorbonne.ufr27.miage.dto.InformationPayment;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import java.io.IOException;

@RequestScoped
public class PaymentServiceImpl implements PaymentService{
    @Inject
    AmexService amexService;

    @Inject
    CamelContext camelContext;

    @Override
    public ConfirmationPayment pay(InformationPayment informationPayment) {
        // send JMS message to AmexPay
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:validatePayment", informationPayment);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // retrieve answer and generate ConfirmationPayment
        ConfirmationPayment confirmationPayment = new ConfirmationPayment();
        confirmationPayment.setIdTransaction(123);
        confirmationPayment.setTransactionStatus(true);

        //if payment is ok, call AmexService to send clientId and ticket price
       if (isPaymentOk(confirmationPayment)) {
           amexService.sendInformationPayment(informationPayment.getIdClient(), informationPayment.getPrice());
        }

        return confirmationPayment;
    }

    public boolean isPaymentOk(ConfirmationPayment confirmationPayment){
        return confirmationPayment.isTransactionStatus();
    }
}
