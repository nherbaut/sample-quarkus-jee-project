package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.PaymentGateway;

import javax.inject.Inject;

public class PaymentServiceImpl implements PaymentService{

    @Inject
    PaymentGateway paymentGateway;

    @Override
    public boolean payByCard(Integer orderId) {
        return false;
    }

    @Override
    public void askPayByCard(Integer orderId) {
        paymentGateway.askPayByCard(orderId);
    }

}
