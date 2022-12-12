package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;

import javax.enterprise.context.ApplicationScoped;

public interface PaymentService {

    void askPayByCard(Float totalPrice) throws OrderNotFoundException, ProductNotFoundException;

    Float cardPayment(Integer orderId) throws OrderNotFoundException;

    void receiveURL(String url);

}
