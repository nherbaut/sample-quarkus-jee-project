package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTOContainer;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import org.apache.camel.ProducerTemplate;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.io.IOException;
import java.util.stream.Collectors;

@ApplicationScoped
public class PaymentGateway {

    @Inject
    CamelContext context;

    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    ProductService productService;

    public void askPayByCard(Float totalPrice){
        try (ProducerTemplate producer = context.createProducerTemplate()){
            producer.sendBody("direct:askByCard", "client is paying by card");
        } catch (IOException e){
            e.printStackTrace();
        }
    }



}
