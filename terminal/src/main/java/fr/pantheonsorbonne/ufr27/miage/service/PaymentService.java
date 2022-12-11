package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;

public interface PaymentService {

    Float askPayByCard(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

}
