package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.ProductGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTOContainer;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductGateway productGateway;

    private Collection<ProductDTO> productDTOS;

    public void askAllProduct() {
        //On va dire au ProductGateway que l'on souhaite récupérer la liste de tous les produits
        //Création du message et de la queue pour demander la liste de produits
        this.productDTOS =null;
        productGateway.askAllProduct();
    }

    @Override
    @Handler
    public void receiveAllProduct(ProductDTOContainer productDTOContainer) {
        this.productDTOS =productDTOContainer.getContainer();
    }

    @Override
    public Collection<ProductDTO> getAllProduct() {
        this.askAllProduct();
        while(this.productDTOS ==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return productDTOS;
    }
}
