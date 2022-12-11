package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;

public interface OrderService {

    OrderDTO createOrder(Integer productId) throws ProductNotFoundException;

    OrderDTO addProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;
    
    void deleteOrder(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    OrderDTO deleteProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

}
