package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class ProductDAOImpl implements ProductDAO{


    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Product findSingleProduct(Integer productId) {
        return (Product) em.createQuery("Select p from Product p where p.id=:productId").setParameter("productId", productId).getSingleResult();

    }
    @Transactional
    public Collection<Product> findAllProduct() {
        return em.createQuery("Select p from Product p").getResultList();
    }
}
