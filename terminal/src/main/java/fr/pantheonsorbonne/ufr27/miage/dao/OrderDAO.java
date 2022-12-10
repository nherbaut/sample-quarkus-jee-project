package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Order;

public interface OrderDAO {

    Order createOrder(Integer productId) throws ProductNotFoundException;

    Order addProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    Order findSingleOrder(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    void deleteOrder(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    Order deleteProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException;
}
