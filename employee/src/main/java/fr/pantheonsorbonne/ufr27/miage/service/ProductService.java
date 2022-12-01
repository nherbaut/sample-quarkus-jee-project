package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTOContainer;
import org.apache.camel.Exchange;

import java.util.Collection;

public interface ProductService {


    void receiveAllProduct(ProductDTOContainer productDTOContainer);


    Collection<ProductDTO> getAllProduct();

}
