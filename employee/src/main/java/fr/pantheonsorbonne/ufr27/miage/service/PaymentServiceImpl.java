package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.PaymentGateway;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService{

    @Inject
    PaymentGateway paymentGateway;

    @Override
    public boolean payByCard(Integer orderId) {
        return true;
    }

    @Override
    public void askPayByCard(Integer orderId) {
        paymentGateway.askPayByCard(orderId);
    }

}
