package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class OrderDAOImpl implements OrderDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Inject
    ProductDAO productDAO;


    @Override
    @Transactional
    public Integer createOrder(Integer productId) {
        List<Product> productList = new ArrayList<>();
        productList.add(productDAO.findSingleProduct(productId));
        Employee employee = new Employee();
        float floatvalue = productDAO.findSingleProduct(productId).getProductPrice();
        employee.setId(1);
        Order o = new Order(UUID.randomUUID().hashCode(), productList  ,LocalDate.now(), floatvalue, null, employee);
        em.persist(o);
        return o.getId();
    }

}
