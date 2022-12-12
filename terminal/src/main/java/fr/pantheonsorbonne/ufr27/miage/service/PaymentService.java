package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;

import javax.enterprise.context.ApplicationScoped;

public interface PaymentService {

    String isAbleForPayment(Integer orderId) throws OrderNotFoundException;

    String readyToPay(Float totalPrice) throws OrderNotFoundException, ProductNotFoundException;

    String receiveURL(String url);

}
