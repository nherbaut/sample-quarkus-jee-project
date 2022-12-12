package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTOContainer;

import java.util.Collection;

public interface ProductService {


    void receiveAllProduct(OrderItemDTOContainer productDTOContainer);


    Collection<OrderItemDTO> getAllProduct();

}
