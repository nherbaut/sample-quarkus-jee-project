package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.service.OrderService;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class OrderGateway {

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext camelContext;

    @Inject
    OrderService orderService;

    public void askCreateOrder(Integer productId){
        try (ProducerTemplate producer = camelContext.createProducerTemplate()){
            producer.sendBody("direct:newOrder",productId.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
        //envoyer dans une route le message au terminal pour lui dire qu'on veut la liste des products
    }

    public void askAddProduct(Integer productId, Integer orderId){
        try (ProducerTemplate producer = camelContext.createProducerTemplate()){
            List<Integer> messageBody = new ArrayList();
            messageBody.add(orderId);
            messageBody.add(productId);
           producer.sendBody("direct:addProductInOrder", messageBody);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void askGetTotalPrice(Integer orderId) {
        try (ProducerTemplate producer = camelContext.createProducerTemplate()) {
            producer.sendBody("direct:getTotalPrice", orderId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void askDeleteOrder(Integer orderId){
        try (ProducerTemplate producer = camelContext.createProducerTemplate()){
            producer.sendBody("direct:deleteOrder",orderId);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void recieveTotalPrice(Float totalPrice){
        orderService.recieveTotalPrice(totalPrice);
    }

    public void askDeleteProduct(Integer productId, Integer orderId) {
        try (ProducerTemplate producer = camelContext.createProducerTemplate()) {
            List<Integer> messageBody = new ArrayList();
            messageBody.add(orderId);
            messageBody.add(productId);
            producer.sendBody("direct:deleteProductFromOrder",messageBody);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
