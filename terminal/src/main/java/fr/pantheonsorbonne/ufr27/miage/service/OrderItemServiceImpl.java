package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.OrderItemDAO;
import fr.pantheonsorbonne.ufr27.miage.model.OrderItem;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class OrderItemServiceImpl implements OrderItemService {

    @Inject
    OrderItemDAO orderItemDAO;

    @Override
    @Handler
    public Collection<OrderItem> getOrderItemList() { //Ici c'est les articles du DTO
        Collection<OrderItem> orderItems = orderItemDAO.findAllItems();
        System.out.println("Liste Des Articles : "+ orderItems);
        return orderItems;
    }
}