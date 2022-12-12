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
    public boolean payByCard(Integer orderId) {
        this.askPayByCard(orderId);
        return true;
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


    @Override
    public String getURL(String url, Integer orderId) {
        try {
            this.payByCard(orderId);
            while (this.url == null) {
                try {
                    Thread.sleep(100);
                } catch (NoResultException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
            return url;
        }catch (NoResultException | InterruptedException e){
            throw new NoResultException();
        }
    }

}
