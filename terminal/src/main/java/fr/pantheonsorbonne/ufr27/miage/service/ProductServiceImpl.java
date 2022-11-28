package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.ProductDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Product;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductDAO productDAO;

    @Override
    @Handler
    public Collection<Product> getProductList() { //Ici c'est le product du DTO
        Collection<Product> products = productDAO.findAllProduct();
        System.out.println("LISTE PRODUCTS"+products);
        return products;
    }
}