package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import java.util.Collection;

public interface OrderService {

    Integer createOrder(Integer productId) throws ProductNotFoundException;

    Integer addProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;
    
    void deleteOrder(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    Integer deleteProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

}
