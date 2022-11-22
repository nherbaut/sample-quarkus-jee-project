package fr.pantheonsorbonne.ufr27.miage.dao;
import fr.pantheonsorbonne.ufr27.miage.dto.Product;
import java.util.Collection;

public interface ProductDAO {

    Product findSingleProduct(String productId);
    Collection<Product> findAllProduct();
}
