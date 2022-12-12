package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.OrderItem;

import java.util.Collection;

public interface OrderItemService {
    Collection<OrderItem> getOrderItemList();
}
