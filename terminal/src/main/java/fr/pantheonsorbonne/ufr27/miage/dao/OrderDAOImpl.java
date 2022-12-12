package fr.pantheonsorbonne.ufr27.miage.dao;


import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.OrderItem;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class OrderDAOImpl implements OrderDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Inject
    OrderItemDAO orderItemDAO;

    @Override
    @Transactional
    public Order findSingleOrder(Integer orderId) throws OrderNotFoundException {
        try {
            return (Order) em.createQuery("Select o from Order o where o.id = :orderId ").setParameter("orderId", orderId).getSingleResult();
        }catch (NoResultException e){
            throw new OrderNotFoundException(orderId);
        }
    }

    @Override
    @Transactional
    public Order createOrder(Integer itemId) throws ItemNotFoundException {
        try {
            List<OrderItem> orderItemList = new ArrayList<>();
            orderItemList.add(orderItemDAO.findSingleItem(itemId));
            Employee employee = new Employee();
            float floatvalue = orderItemDAO.findSingleItem(itemId).getItemPrice();
            employee.setId(1);
            Order o = new Order(orderItemList, new Date(), floatvalue, null, employee);
            em.persist(o);
            return o;
        }catch (NoResultException e){
            throw new ItemNotFoundException(itemId);
        }
    }

    @Override
    @Transactional
    public Order addItemOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        try {
            Order o = findSingleOrder(orderId);
            OrderItem orderItem = orderItemDAO.findSingleItem(itemId);
            List<OrderItem> orderItemList = o.getOrderContent();
            orderItemList.add(orderItem);
            o.setOrderContent(orderItemList);
            o.setOrderPrice(o.getOrderPrice() + orderItem.getItemPrice());
            em.persist(o);
            return o;
        }catch (NoResultException e){
            throw new ItemNotFoundException(itemId);
        }
    }

    @Override
    @Transactional
    public Float getTotalPrice(Integer orderId) throws OrderNotFoundException {
        Order o = this.findSingleOrder(orderId);
        return o.getOrderPrice();
    }
    @Override
    @Transactional
    public void deleteOrder(Integer orderId) throws OrderNotFoundException {
        Order o = this.findSingleOrder(orderId);
        em.remove(o);
    }

    @Override
    @Transactional
    public Order deleteItemOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        try {
            Order o = findSingleOrder(orderId);
            OrderItem orderItem = orderItemDAO.findSingleItem(itemId);
            List<OrderItem> orderItemList = o.getOrderContent();
            orderItemList.remove(orderItem);
            o.setOrderContent(orderItemList);
            o.setOrderPrice(o.getOrderPrice() - orderItem.getItemPrice());
            em.persist(o);
            return o;
        }catch (NoResultException e){
            throw new ItemNotFoundException(itemId);
        }
    }

}
