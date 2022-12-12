package fr.pantheonsorbonne.ufr27.miage.dao;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Order;

public interface OrderDAO {

    Integer createOrder(Integer itemId) throws ItemNotFoundException;

    void deleteOrder(Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Integer addItemOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Order findSingleOrder(Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Integer deleteItemOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException;
}
