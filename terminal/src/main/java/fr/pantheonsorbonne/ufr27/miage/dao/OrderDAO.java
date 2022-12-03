package fr.pantheonsorbonne.ufr27.miage.dao;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import java.util.Collection;

public interface OrderDAO {

    Integer createOrder(Integer productId);

    Integer addProductOrder(Integer productId, Integer orderId);

    Order findSingleOrder(Integer orderId);

    Float getTotalPrice(Integer orderId);
    void deleteOrder(Integer orderId);

    Integer deleteProductOrder(Integer productId, Integer orderId);
}
