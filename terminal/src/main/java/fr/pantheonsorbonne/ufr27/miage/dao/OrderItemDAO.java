package fr.pantheonsorbonne.ufr27.miage.dao;
import fr.pantheonsorbonne.ufr27.miage.model.OrderItem;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import java.util.Collection;

public interface OrderItemDAO {

    OrderItem findSingleItem(Integer itemId);
    Collection<OrderItem> findAllItems();
}
