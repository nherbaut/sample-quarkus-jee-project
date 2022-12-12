package fr.pantheonsorbonne.ufr27.miage.dao;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import java.util.Collection;

public interface ProductDAO {

    Product findSingleProduct(Integer productId);
    Collection<Product> findAllProduct();
}
