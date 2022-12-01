package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.UUID;

@ApplicationScoped
public class OrderDAOImpl implements OrderDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Transactional
    public Order createOrder(Integer productId) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId_product(productId.toString());
        float floatvalue = 0;
        Employee employee = new Employee();
        employee.setId(1);
        Client client = new Client();
        client.setId(1);
        Order o = new Order(UUID.randomUUID().hashCode(), LocalDate.now(), floatvalue ,productDTO.getId_product(), employee , client);
        em.persist(o);
        return o;
    }

}
