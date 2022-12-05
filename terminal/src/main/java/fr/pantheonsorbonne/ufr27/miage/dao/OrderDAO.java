package fr.pantheonsorbonne.ufr27.miage.dao;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import java.util.Collection;

public interface OrderDAO {

    Integer createOrder(Integer productId) throws ProductNotFoundException;

    Integer addProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    Order findSingleOrder(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;
    void deleteOrder(Integer orderId) throws OrderNotFoundException, ProductNotFoundException;

    Integer deleteProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException;
}
