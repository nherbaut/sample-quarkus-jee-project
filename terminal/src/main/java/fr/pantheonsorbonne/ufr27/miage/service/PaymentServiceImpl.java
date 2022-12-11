package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.PaymentGateway;
import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;

import javax.inject.Inject;

public class PaymentServiceImpl implements PaymentService{

    @Inject
    OrderDAO orderDao;
    @Inject
    PaymentGateway paymentGateway;

    @Override
    public Float askPayByCard(Integer orderId) throws OrderNotFoundException {
        return orderDao.findSingleOrder(orderId).getOrderPrice();
    }

    public void cardPaiement(Float totalPrice) {
        paymentGateway.askPayByCard(totalPrice);
    }

}
