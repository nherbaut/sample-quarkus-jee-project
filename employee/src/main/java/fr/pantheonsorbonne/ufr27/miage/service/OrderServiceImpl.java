package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.OrderGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class OrderServiceImpl implements OrderService{

    @Inject
    OrderGateway orderGateway;

    private OrderDTO orderDTO;

    private Float res;

    @Override
    public OrderDTO createOrder(Integer productId) {
        this.askCreateOrder(productId);
        return orderDTO;
    }

    @Override
    public void askCreateOrder(Integer productId) {
        orderGateway.askCreateOrder(productId);
    }

    @Override
    public OrderDTO addProduct(Integer productId, Integer orderId){
        this.askAddProduct(productId,orderId);
        return orderDTO;
    }

    @Override
    public void askAddProduct(Integer productId, Integer orderId){
        orderGateway.askAddProduct(productId,orderId);

    }

    @Override
    public OrderDTO deleteProduct(String productId) {
        return null;
    }

    @Override
    public boolean deleteOrder() {
        return false;
    }

    public void askTotalPrice(Integer orderId){
        this.res = null;
        orderGateway.askGetTotalPrice(orderId);
    }

    @Override
    public Float getTotalPrice(Integer orderId) {
        this.askTotalPrice(orderId);
        while(this.res==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return res;
    }

    @Override
    @Handler
    public void recieveTotalPrice(Float totalPrice) {
        this.res = totalPrice;
    }

}
