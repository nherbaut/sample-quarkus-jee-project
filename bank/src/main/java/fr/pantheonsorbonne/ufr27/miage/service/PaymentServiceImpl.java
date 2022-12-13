package fr.pantheonsorbonne.ufr27.miage.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService{

    String url = "http://localhost:8082/payment";

    @Override
    public String sendRedirectURL() {
        return this.url;
    }

    @Override
    public Integer getCardPassword(Integer clientId) {
        return null;
    }

}
