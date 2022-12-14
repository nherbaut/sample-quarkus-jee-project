package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.ClientNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.PasswordIncorrectException;
import fr.pantheonsorbonne.ufr27.miage.exception.SoldUnsifficientException;

public interface PaymentService {

    String sendRedirectURL(Float totalPrice);

    boolean cardPayment(Integer clientId, Integer password) throws ClientNotFoundException, PasswordIncorrectException, SoldUnsifficientException;

    void sendPaidPrice(Float sendPrice);
}
