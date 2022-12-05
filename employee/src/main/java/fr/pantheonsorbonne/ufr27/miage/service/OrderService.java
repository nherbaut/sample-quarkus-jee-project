package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;

public interface OrderService {

    OrderDTO createOrder(Integer productId) throws ProductNotFoundException;

    void askCreateOrder(Integer productId);

    void askAddProduct(Integer productId, Integer orderId);

    OrderDTO addProduct(Integer productId, Integer orderId);

    void deleteOrder(Integer orderId) throws OrderNotFoundException;

    void askTotalPrice(Integer orderId);
    Float getTotalPrice(Integer orderId) throws OrderNotFoundException;
    void recieveTotalPrice(Float totalPrice);

    void askDeleteProduct(Integer productId, Integer orderId);
    OrderDTO deleteProduct(Integer orderId, Integer productId);
}

