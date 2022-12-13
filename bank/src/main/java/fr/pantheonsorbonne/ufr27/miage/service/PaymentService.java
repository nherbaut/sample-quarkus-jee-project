package fr.pantheonsorbonne.ufr27.miage.service;

public interface PaymentService {

    String sendRedirectURL();

    Integer getCardPassword(Integer clientId);
}
