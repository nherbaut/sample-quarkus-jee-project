package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.OrderGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.criteria.Order;

@RequestScoped
public class OrderServiceImpl implements OrderService{

    @Inject
    OrderGateway orderGateway;

    private OrderDTO orderDTO;

    @Override
    public OrderDTO createOrder(Integer productId) {
        this.askCreateOrder(productId);
        return orderDTO;
    }

    @Override
    public void askCreateOrder(Integer productId) {
        orderGateway.askCreateOrder(productId);
    }

    @Override
    public OrderDTO addProduct(String productId) {
        return null;
    }

    @Override
    public OrderDTO deleteProduct(String productId) {
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
