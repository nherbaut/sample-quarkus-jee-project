package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;

public interface PaymentService {

    Float isAbleForPayment(Integer orderId) throws OrderNotFoundException;

    String readyToPay(Float totalPrice) throws OrderNotFoundException;

    String receiveURL(String url);

}
