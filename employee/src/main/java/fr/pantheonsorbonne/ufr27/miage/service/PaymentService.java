package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;

public interface PaymentService {

    boolean payByCard(Integer orderId);

    void askPayByCard(Integer orderId);

    void receiveURL(String url);

    String getURL(String url, Integer orderId);
}
