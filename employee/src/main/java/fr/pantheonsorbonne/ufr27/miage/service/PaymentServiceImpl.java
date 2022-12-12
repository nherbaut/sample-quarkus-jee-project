package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.PaymentGateway;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService{

    @Inject
    PaymentGateway paymentGateway;

    String url;

    @Override
    public String payByCard(Integer orderId) {
        this.askPayByCard(orderId);
        while (this.url == null) {
            try {
                Thread.sleep(100);
            } catch (NoResultException | InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return url;
    }

    @Override
    public void askPayByCard(Integer orderId) {
        paymentGateway.askPayByCard(orderId);
    }

    @Override
    @Handler
    public void receiveURL(String url) {
        this.url = url;
    }

}
