package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.OrderDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.ProductDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.OrderNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ProductNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Order;
import fr.pantheonsorbonne.ufr27.miage.model.Product;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    ProductDAO productDAO;

    @Inject
    OrderDAO orderDAO;

    private OrderDTO convertOrderToOrderDTO(Order o){
        Collection<ProductDTO> pp = new ArrayList<>();
        for (Product p : o.getProducts()){
            pp.add(new ProductDTO(p.getProductPrice(), p.getId(), p.getProductType()));
        }
        // TODO mettre une condition pour vérifier si le client s'est connecté pour mettre son clientId dans l'orderDTO
        return  new OrderDTO(o.getId(), o.getOrderDate(), o.getOrderPrice(), o.getEmployee().getId(), null, o.getOrderPrice(), pp);
    }

    public Collection<Product> getProductList() {
        Collection<Product> products = productDAO.findAllProduct();
        return products;
    }

    @Override
    public OrderDTO createOrder(Integer productId) throws ProductNotFoundException {
        Order o = orderDAO.createOrder(productId);
        return convertOrderToOrderDTO(o);
    }

    @Override
    public OrderDTO addProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException {
        Order o = orderDAO.addProductOrder(productId, orderId);
        return convertOrderToOrderDTO(o);
    }

    @Override
    public OrderDTO deleteProductOrder(Integer productId, Integer orderId) throws OrderNotFoundException, ProductNotFoundException {
        Order o = orderDAO.deleteProductOrder(productId,orderId);
        return convertOrderToOrderDTO(o);
    }
    @Override
    public Float getTotalPrice(Integer orderId) throws OrderNotFoundException, ProductNotFoundException {
        return orderDAO.getTotalPrice(orderId);
    }

    public void deleteOrder(Integer orderId) throws OrderNotFoundException, ProductNotFoundException {
        orderDAO.deleteOrder(orderId);
    }
}