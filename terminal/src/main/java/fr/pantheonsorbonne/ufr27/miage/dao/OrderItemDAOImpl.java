package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.OrderItem;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class OrderItemDAOImpl implements OrderItemDAO {


    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Transactional
    @Override
    public OrderItem findSingleItem(Integer itemId) {
        return (OrderItem) em.createQuery("Select item from OrderItem item where item.id=:itemId").setParameter("itemId", itemId).getSingleResult();

    }
    @Transactional
    public Collection<OrderItem> findAllItems() {
        return em.createQuery("Select i from OrderItem i").getResultList();
    }
}
