package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Order;

public interface OrderService {

    Order createOrder();

    Order addProduct(String productId);

    Order deleteProduct(String productId);

    boolean deleteOrder();

    Float getTotal();

}
