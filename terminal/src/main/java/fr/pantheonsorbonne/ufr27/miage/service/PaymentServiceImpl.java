package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.PaymentGateway;
import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.ItemNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService{

    @Inject
    OrderDAO orderDao;

    String url;

    @Override
    public Float isAbleForPayment(Integer orderId) throws OrderNotFoundException{
        Order o = orderDao.findSingleOrder(orderId);
        if (o.getOrderPrice() > 0){
            return o.getOrderPrice();
            //init payment
            //send msg to bank to tell her we want to pay
        } else {
            //throw exception total <= 0
            throw new OrderNotFoundException(orderId);
        }
    }

    @Override
    public String readyToPay(Float totalPrice) {
        this.url = null;
        return "ok "+totalPrice;
    }

    @Override
    @Handler
    public String receiveURL(String url) {
        this.url = url;
        return this.url;
    }
}
