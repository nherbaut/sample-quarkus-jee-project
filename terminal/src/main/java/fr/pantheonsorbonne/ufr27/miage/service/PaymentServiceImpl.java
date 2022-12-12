package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.PaymentGateway;
import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService{

    @Inject
    OrderDAO orderDao;
    @Inject
    PaymentGateway paymentGateway;

    String url;

    @Override
    public void askPayByCard(Float totalPrice) throws OrderNotFoundException {
        paymentGateway.askPayByCard(totalPrice);
    }

    @Override
    public Float cardPayment(Integer orderId) throws OrderNotFoundException {
        this.askPayByCard(orderDao.findSingleOrder(orderId).getOrderPrice());
        return orderDao.findSingleOrder(orderId).getOrderPrice();
    }

    @Override
    @Handler
    public void receiveURL(String url) {
        this.url = url;
    }
}
