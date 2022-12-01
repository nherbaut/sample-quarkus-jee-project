package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;

public interface OrderService {

    OrderDTO createOrder(Integer productId);

    void askCreateOrder(Integer productId);

    void askAddProduct(Integer productId, Integer orderId);

    OrderDTO addProduct(Integer productId, Integer orderId);

    OrderDTO deleteProduct(String productId);

    boolean deleteOrder();

    Float getTotal();

}
