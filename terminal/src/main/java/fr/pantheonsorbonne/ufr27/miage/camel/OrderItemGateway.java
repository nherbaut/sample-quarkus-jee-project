package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTOContainer;
import fr.pantheonsorbonne.ufr27.miage.service.OrderItemService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import org.modelmapper.ModelMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderItemGateway {

    @Inject
    CamelContext context;

    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    OrderItemService orderItemService;

    @Handler
    OrderItemDTOContainer getItems(String msg){

        ModelMapper modelMapper = new ModelMapper();

        return new OrderItemDTOContainer(orderItemService.getOrderItemList().stream().map(p->new OrderItemDTO(p.getItemPrice(),p.getId(),p.getItemName())).collect(Collectors.toList()));


    }

}
