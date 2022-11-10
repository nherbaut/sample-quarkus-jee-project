package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.OrderGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.Order;

import javax.inject.Inject;

public class OrderServiceImpl implements OrderService{

    @Inject
    OrderGateway orderGateway;

    @Override
    public Order createOrder() {
        //Créer l'order dans le terminal
        return null;
    }

    @Override
    public Order addProduct(String productId) {
        return null;
    }

    @Override
    public Order deleteProduct(String productId) {
        return null;
    }

    @Override
    public boolean deleteOrder() {
        return false;
    }

    @Override
    public Float getTotal() {
        return null;
    }
}
