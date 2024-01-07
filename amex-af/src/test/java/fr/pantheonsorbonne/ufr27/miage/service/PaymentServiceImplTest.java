package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.ConfirmationPayment;
import fr.pantheonsorbonne.ufr27.miage.dto.InformationPayment;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.engine.DefaultProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.support.DefaultMessage;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    CamelContext camelContext;

    @Mock
    AmexService amexService;

    @Test
    void should_return_ConfirmationPayment_with_status_OK() {
        Mockito.when(camelContext.createProducerTemplate()).thenReturn(new FakeProducerTemplate(camelContext));

        InformationPayment informationPayment = new InformationPayment();
        informationPayment.setIdClient(12345);
        informationPayment.setPrice(450);
        informationPayment.setCardNumber("AA123GTH33");
        informationPayment.setIdTicket(567);
        ConfirmationPayment confirmationPayment = paymentService.pay(informationPayment);

        Assertions.assertTrue(confirmationPayment.isTransactionStatus());
        Assertions.assertNull(confirmationPayment.getErrorMessage());
        verify(amexService, Mockito.times(1)).sendInformationPayment(anyInt(), anyFloat());
    }

    @Test
    void should_return_ConfirmationPayment_with_status_KO(){
        Mockito.when(camelContext.createProducerTemplate()).thenReturn(new FakeProducerTemplate(camelContext));

        InformationPayment informationPayment = new InformationPayment();
        informationPayment.setIdClient(12345);
        informationPayment.setPrice(45000);
        informationPayment.setCardNumber("AA123GTH33");
        informationPayment.setIdTicket(567);
        ConfirmationPayment confirmationPayment = paymentService.pay(informationPayment);

        Assertions.assertFalse(confirmationPayment.isTransactionStatus());
        Assertions.assertEquals("Amount too high", confirmationPayment.getErrorMessage());
        verify(amexService, never()).sendInformationPayment(anyInt(), anyFloat());
    }

    @Test
    void should_return_TechnicalError(){
        Mockito.when(camelContext.createProducerTemplate()).thenReturn(new FakeProducerTemplate(camelContext));
        InformationPayment informationPayment = new InformationPayment();
        ConfirmationPayment confirmationPayment = paymentService.pay(informationPayment);

        Assertions.assertFalse(confirmationPayment.isTransactionStatus());
        Assertions.assertEquals("No reply received from AmexPay", confirmationPayment.getErrorMessage());
        verify(amexService, never()).sendInformationPayment(anyInt(), anyFloat());
    }

    public static class FakeProducerTemplate extends DefaultProducerTemplate {
        public FakeProducerTemplate(CamelContext camelContext) {
            super(camelContext);
        }

        public Exchange send(String uri, Exchange in) {
            Exchange reply = new DefaultExchange(this.getCamelContext());
            InformationPayment informationPayment = in.getMessage().getBody(InformationPayment.class);
            if (StringUtils.isBlank(informationPayment.getCardNumber())) {
                return reply;
            }
            ConfirmationPayment payment = new ConfirmationPayment();
            payment.setIdTransaction(12345);
            if (informationPayment.getPrice() < 5000) {
                payment.setTransactionStatus(true);
            } else {
                payment.setTransactionStatus(false);
                payment.setErrorMessage("Amount too high");
            }
            Message response = new DefaultMessage(this.getCamelContext());
            response.setBody(payment);
            reply.setOut(response);
            return reply;
        }
    }
}
