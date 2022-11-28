package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Product;
import org.apache.camel.Exchange;

import java.util.Collection;

public interface ProductService {
    Collection<Product> getProductList();
}
