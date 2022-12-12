package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;

public interface PaymentService {

    String payByCard(Integer orderId);

    void askPayByCard(Integer orderId);

    void receiveURL(String url);

}
