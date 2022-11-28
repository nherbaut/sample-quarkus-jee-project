package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Product;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@RequestScoped
public class ProductDAOImpl implements ProductDAO{
    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Product findSingleProduct(String productId) {
        return null;
    }
    public Collection<Product> findAllProduct() {
        return em.createQuery("Select p from Product p").getResultList();
    }
}
