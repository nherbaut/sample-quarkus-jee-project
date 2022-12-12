package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.OrderItemDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.OrderItem;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    OrderItemDAO orderItemDAO;

    @Inject
    OrderDAO orderDAO;

    public Collection<OrderItem> getOrderItemList() { //Ici c'est les articles du DTO
        Collection<OrderItem> orderItems = orderItemDAO.findAllItems();
        System.out.println("Liste Des Articles : "+ orderItems);
        return orderItems;
    }

    @Override
    public Integer createOrder(Integer itemId) throws ItemNotFoundException {
        return  orderDAO.createOrder(itemId);
    }

    @Override
    public Integer addItemToOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        return orderDAO.addItemOrder(itemId,orderId);
    }

    @Override
    public Integer deleteItemOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        return orderDAO.deleteItemOrder(itemId,orderId);
    }
    @Override
    public Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        return orderDAO.getTotalPrice(orderId);
    }

    public void deleteOrder(Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        orderDAO.deleteOrder(orderId);
    }
}