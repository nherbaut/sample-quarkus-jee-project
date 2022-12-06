package fr.pantheonsorbonne.ufr27.miage.service;

public interface PaymentService {

    boolean payByCard(Integer orderId);

    void askPayByCard(Integer orderId);
}
