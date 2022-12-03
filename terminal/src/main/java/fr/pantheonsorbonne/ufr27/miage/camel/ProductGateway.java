package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTOContainer;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import org.modelmapper.ModelMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductGateway {

    @Inject
    CamelContext context;

    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    ProductService productService;

    @Handler
    ProductDTOContainer getProducts(String msg){

        ModelMapper modelMapper = new ModelMapper();

        return new ProductDTOContainer(productService.getProductList().stream().map(p->new ProductDTO(p.getProductPrice(),""+p.getId(),p.getProductName())).collect(Collectors.toList()));


    }


}
