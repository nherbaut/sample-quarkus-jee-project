package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.OrderGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    OrderGateway orderGateway;

    private OrderDTO orderDTO;

    private Float totalPrice;

    @Override
    public void receiveOrder(OrderDTO order) {
        this.orderDTO = order;
    }

    @Override
    public OrderDTO createOrder(Integer productId) {
        this.askCreateOrder(productId);
        while(this.orderDTO==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return orderDTO;
    }

    @Override
    public void askCreateOrder(Integer productId) {
        this.orderDTO = null;
        orderGateway.askCreateOrder(productId);
    }

    @Override
    public OrderDTO addProduct(Integer productId, Integer orderId) {
        this.askAddProduct(productId, orderId);
        while(this.orderDTO==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return orderDTO;
    }

    @Override
    public void askAddProduct(Integer productId, Integer orderId) {
        this.orderDTO = null;
        orderGateway.askAddProduct(productId, orderId);
    }

    @Override
    public void askDeleteProduct(Integer productId, Integer orderId) {
        this.orderDTO = null;
        orderGateway.askDeleteProduct(productId, orderId);
    }

    @Override
    public OrderDTO deleteProduct(Integer orderId, Integer productId) {
        this.askDeleteProduct(productId, orderId);
        while(this.orderDTO==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return orderDTO;
    }

    @Override
    public void deleteOrder(Integer orderId) throws OrderNotFoundException {
        orderGateway.askDeleteOrder(orderId);
    }

    public void askTotalPrice(Integer orderId) {
        this.totalPrice = null;
        orderGateway.askGetTotalPrice(orderId);
    }

    @Override
    public Float getTotalPrice(Integer orderId) throws OrderNotFoundException {
        try {
            this.askTotalPrice(orderId);
            while (this.totalPrice == null) {
                try {
                    Thread.sleep(100);
                } catch (NoResultException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
            return totalPrice;
        }catch (NoResultException | InterruptedException e){
            throw new OrderNotFoundException();
        }
    }

    @Override
    @Handler
    public void receiveTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

}
