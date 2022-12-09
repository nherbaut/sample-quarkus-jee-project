package fr.pantheonsorbonne.ufr27.miage.dao;


import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.Product;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class OrderDAOImpl implements OrderDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Inject
    ProductDAO productDAO;

    @Override
    public Order findSingleOrder(Integer orderId) throws OrderNotFoundException {
        try {
            return (Order) em.createQuery("Select o from Order o where o.id = :orderId ").setParameter("orderId", orderId).getSingleResult();
        }catch (NoResultException e){
            throw new OrderNotFoundException(orderId);
        }
    }

    @Override
    @Transactional
    public Integer createOrder(Integer productId) throws ProductNotFoundException {
        try {
            List<Product> productList = new ArrayList<>();
            productList.add(productDAO.findSingleProduct(productId));
            Employee employee = new Employee();
            float floatvalue = productDAO.findSingleProduct(productId).getProductPrice();
            employee.setId(1);
            Order o = new Order(UUID.randomUUID().hashCode(), productList, LocalDate.now(), floatvalue, null, employee);
            em.persist(o);
            return o.getId();
        }catch (NoResultException e){
            throw new ProductNotFoundException(productId);
        }
    }

    @Override
    @Transactional
    public Integer addProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException {
        try {
            Order o = findSingleOrder(orderId);
            Product product = productDAO.findSingleProduct(productId);
            List<Product> productList = o.getProducts();
            productList.add(product);
            o.setProducts(productList);
            o.setOrderPrice(o.getOrderPrice() + product.getProductPrice());
            em.persist(o);
            return o.getId();
        }catch (NoResultException e){
            throw new ProductNotFoundException(productId);
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
    public Integer deleteProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException {
        try {
            Order o = findSingleOrder(orderId);
            Product product = productDAO.findSingleProduct(productId);
            List<Product> productList = o.getProducts();
            productList.remove(product);
            o.setProducts(productList);
            o.setOrderPrice(o.getOrderPrice() - product.getProductPrice());
            em.persist(o);
            return o.getId();
        }catch (NoResultException e){
            throw new ProductNotFoundException(productId);
        }
    }

}
