package fr.pantheonsorbonne.ufr27.miage.service;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import fr.pantheonsorbonne.ufr27.miage.dao.ClientDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.OrderItemDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.OrderItem;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    OrderItemDAO orderItemDAO;

    @Inject
    OrderDAO orderDAO;

    @Inject
    ClientDAO clientDAO;

    Client client = null;

    private OrderDTO convertOrderToOrderDTO(Order o){
        Collection<OrderItemDTO> pp = new ArrayList<>();
        for (OrderItem p : o.getOrderContent()){
            pp.add(new OrderItemDTO(p.getItemPrice(), p.getId(), p.getItemName()));
        }
        // TODO mettre une condition pour vérifier si le client s'est connecté pour mettre son clientId dans l'orderDTO
        return  new OrderDTO(o.getId(), o.getOrderDate(), o.getOrderPrice(), o.getEmployee().getId(), this.client.getId(), o.getOrderPrice(), pp);
    }
    public Collection<OrderItem> getOrderItemList() { //Ici c'est les articles du DTO
        Collection<OrderItem> orderItems = orderItemDAO.findAllItems();
        System.out.println("Liste Des Articles : "+ orderItems);
        return orderItems;
    }

    @Override
    public OrderDTO createOrder(Integer itemId) throws ItemNotFoundException {
        Order o = orderDAO.createOrder(itemId);
        return convertOrderToOrderDTO(o);
    }

    @Override
    public OrderDTO addItemToOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        Order o = orderDAO.addItemOrder(itemId, orderId);
        OrderItem drink = null;
        OrderItem dessert = null;
        OrderItem sandwich = null;
        for(int i =0 ; i<o.getOrderContent().size(); i++){
            if(o.getOrderContent().get(i).getItem_type().equals("Drink")) {drink = orderItemDAO.findSingleItem(o.getOrderContent().get(i).getId());}
            if (o.getOrderContent().get(i).getItem_type().equals("Dessert")){dessert = orderItemDAO.findSingleItem(o.getOrderContent().get(i).getId());}
            if (o.getOrderContent().get(i).getItem_type().equals("Sandwich")){sandwich = orderItemDAO.findSingleItem(o.getOrderContent().get(i).getId());}
        }
        if (drink != null && dessert != null && sandwich != null){
            orderDAO.deleteItemOrder(drink.getId(), orderId);
            orderDAO.deleteItemOrder(dessert.getId(), orderId);
            orderDAO.deleteItemOrder(sandwich.getId(), orderId);
            orderDAO.addItemOrder(8, orderId);
        }
        else if (drink != null && dessert != null && sandwich == null){
            orderDAO.deleteItemOrder(drink.getId(), orderId);
            orderDAO.deleteItemOrder(dessert.getId(), orderId);
            orderDAO.addItemOrder(7, orderId);
        }
        return convertOrderToOrderDTO(o);}

    @Override
    public OrderDTO deleteItemOrder(Integer itemId, Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        Order o = orderDAO.deleteItemOrder(itemId,orderId);
        return convertOrderToOrderDTO(o);
    }
    @Override
    public Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        return orderDAO.getTotalPrice(orderId);
    }

    public void deleteOrder(Integer orderId) throws OrderNotFoundException, ItemNotFoundException {
        orderDAO.deleteOrder(orderId);
    }

    @Override
    public void setClient(Integer clientId) {
        this.client = clientDAO.findClient(clientId);
        System.out.println(this.client);
    }
}