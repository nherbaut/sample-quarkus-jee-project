package fr.pantheonsorbonne.ufr27.miage.dao;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Order;

public interface OrderDAO {

    Order createOrder(Integer itemId) throws ItemNotFoundException;

    void deleteOrder(Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Order addItemOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Order findSingleOrder(Integer orderId) throws OrderNotFoundException;

    Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ItemNotFoundException;

    Order deleteItemOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException;
}
