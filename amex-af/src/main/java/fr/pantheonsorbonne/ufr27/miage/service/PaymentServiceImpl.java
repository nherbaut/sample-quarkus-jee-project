package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.ConfirmationPayment;
import fr.pantheonsorbonne.ufr27.miage.dto.InformationPayment;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@RequestScoped
public class PaymentServiceImpl implements PaymentService{
    @Inject
    AmexService amexService;

    @Inject
    CamelContext camelContext;

    Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override
    public ConfirmationPayment pay(InformationPayment informationPayment) {
        ConfirmationPayment confirmationPayment;
        // send JMS message to AmexPay
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            Exchange in = new DefaultExchange(camelContext);
            in.getIn().setBody(informationPayment);
            Exchange reply = producerTemplate.send("direct:validatePayment", in);
            if (reply.getOut().getBody() == null) {
                String cause;
                if (reply.getException()!= null) {
                    cause = reply.getException().getMessage();
                } else {
                    cause = "Technical error";
                }
                confirmationPayment = new ConfirmationPayment();
                confirmationPayment.setTransactionStatus(false);
                confirmationPayment.setErrorMessage("No reply received from AmexPay");
                log.error("No reply received from AmexPay: {}", cause);
            } else {
                confirmationPayment = reply.getOut().getBody(ConfirmationPayment.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       //if payment is ok, call AmexService to send client and ticket price
       if (isPaymentOk(confirmationPayment)) {
           amexService.sendInformationPayment(informationPayment.getClient(), informationPayment.getPrice());
        }

        return confirmationPayment;
    }
    public boolean isPaymentOk(ConfirmationPayment confirmationPayment){
        return confirmationPayment.isTransactionStatus();
    }
}
