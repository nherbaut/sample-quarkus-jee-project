package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;

public interface OrderService {

    Integer createOrder(Integer itemId) throws ItemNotFoundException;

    void deleteOrder(Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Integer addItemToOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Integer deleteItemOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

}
