package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.ProductDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.ProductDAOImpl;
import fr.pantheonsorbonne.ufr27.miage.dto.Product;
import javax.enterprise.context.RequestScoped;
import java.util.Collection;

@RequestScoped
public class ProductServiceImpl implements ProductService {

    @Override
    public Collection<Product> getProductList() { //Ici c'est le product du DTO
        ProductDAO productDAO = new ProductDAOImpl();
        return productDAO.findAllProduct();
    }
}
