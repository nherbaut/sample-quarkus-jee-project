package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.OrderGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;
import org.apache.camel.Handler;
import org.hibernate.criterion.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    OrderGateway orderGateway;

    private OrderDTO orderDTO;

    private Float res;

    @Override
    public OrderDTO createOrder(Integer productId) throws ProductNotFoundException {
        try {
            this.askCreateOrder(productId);
            return orderDTO;
        }catch (NoResultException e){
            throw new ProductNotFoundException(productId);
        }
    }

    @Override
    public void askCreateOrder(Integer productId) {
        orderGateway.askCreateOrder(productId);
    }

    @Override
    public OrderDTO addProduct(Integer productId, Integer orderId) {
        this.askAddProduct(productId, orderId);
        return orderDTO;
    }

    @Override
    public void askAddProduct(Integer productId, Integer orderId) {
        orderGateway.askAddProduct(productId, orderId);

    }

    @Override
    public void askDeleteProduct(Integer productId, Integer orderId) {
        orderGateway.askDeleteProduct(productId, orderId);

    }

    @Override
    public OrderDTO deleteProduct(Integer orderId, Integer productId) {

        this.askDeleteProduct(productId, orderId);
        return orderDTO;
    }


    @Override
    public void deleteOrder(Integer orderId) throws OrderNotFoundException {
        orderGateway.askDeleteOrder(orderId);
    }

    public void askTotalPrice(Integer orderId) {
        this.res = null;
        orderGateway.askGetTotalPrice(orderId);
    }

    @Override
    public Float getTotalPrice(Integer orderId) throws OrderNotFoundException {
        try {
            this.askTotalPrice(orderId);
            while (this.res == null) {
                try {
                    Thread.sleep(100);
                } catch (NoResultException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
            return res;
        }catch (NoResultException | InterruptedException e){
            throw new OrderNotFoundException();
        }
    }

    @Override
    @Handler
    public void recieveTotalPrice(Float totalPrice) {
        this.res = totalPrice;
    }

}
