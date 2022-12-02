package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import java.util.Collection;

public interface OrderService {

    Integer createOrder(Integer productId);

    Integer addProductOrder(Integer productId, Integer orderId);

    Float getTotalPrice(Integer orderId);
    
    void deleteOrder(Integer orderId);

}
