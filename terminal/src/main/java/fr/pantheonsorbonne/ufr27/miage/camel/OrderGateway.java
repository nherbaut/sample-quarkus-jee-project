package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.util.List;

@ApplicationScoped
public class OrderGateway {

    @Inject
    CamelContext context;

    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    OrderService orderService;

    @Handler

    public OrderDTO createOrder(Integer message) throws ItemNotFoundException {
        return  orderService.createOrder(message);
    }

    @Handler
    public void deleteOrder(Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        orderService.deleteOrder(orderId);
    }

    @Handler
    public OrderDTO addItemToOrder(List<Integer> messageBody) throws OrderNotFoundException, ItemNotFoundException {
        return orderService.addItemToOrder(messageBody.get(1),messageBody.get(0));
    }

    @Handler
    public OrderDTO deleteItemOrder(List<Integer> messageBody) throws OrderNotFoundException, ItemNotFoundException {
        return orderService.deleteItemOrder(messageBody.get(1),messageBody.get(0));
    }

    @Handler
    public Float getTotalPrice(Integer message) throws OrderNotFoundException, ItemNotFoundException {
        return orderService.getTotalPrice(message);
    }
}
