package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.ProductDAO;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.Product;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    ProductDAO productDAO;

    @Inject
    OrderDAO orderDAO;

    public Collection<Product> getProductList() { //Ici c'est le product du DTO
        Collection<Product> products = productDAO.findAllProduct();
        System.out.println("LISTE PRODUCTS"+products);
        return products;
    }

    @Override
    public Integer createOrder(Integer productId) {
        return  orderDAO.createOrder(productId);
    }

    @Override
    public Integer addProductOrder(Integer productId, Integer orderId) {
        return orderDAO.addProductOrder(productId,orderId);
    }

    @Override
    public Float getTotalPrice(Integer orderId){
        return orderDAO.getTotalPrice(orderId);
    }

    public void deleteOrder(Integer orderId){
        orderDAO.deleteOrder(orderId);
    }
}