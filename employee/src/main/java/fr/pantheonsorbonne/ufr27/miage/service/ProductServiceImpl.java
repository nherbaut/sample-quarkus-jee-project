package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.ProductGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.Product;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductGateway productGateway;

    private Collection<Product> res;

    @Override
    public void askAllProduct() {
        //On va dire au ProductGateway que l'on souhaite récupérer la liste de tous les produits
        //Création du message et de la queue pour demander la liste de produits
        productGateway.askAllProduct();
    }

    @Override
    @Handler
    public Collection<Product> receiveAllProduct(Exchange exchange) {
        return getAllProduct((Collection<Product>) exchange.getMessage().getBody());
    }

    @Override
    public Collection<Product> getAllProduct(Collection<Product> products) {
        return products;
    }
}
