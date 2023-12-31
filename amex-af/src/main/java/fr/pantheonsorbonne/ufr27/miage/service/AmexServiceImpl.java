package fr.pantheonsorbonne.ufr27.miage.service;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class AmexServiceImpl implements AmexService{
    @Override
    public void sendInformationPayment(int idClient, float price) {
        //send jms message to amex
    }
}
