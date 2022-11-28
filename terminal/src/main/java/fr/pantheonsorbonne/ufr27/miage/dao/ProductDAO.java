package fr.pantheonsorbonne.ufr27.miage.dao;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import java.util.Collection;

public interface ProductDAO {

    ProductDTO findSingleProduct(String productId);
    Collection<Product> findAllProduct();
}
