package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.ProductGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.OrderItemDTOContainer;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductGateway productGateway;

    private Collection<OrderItemDTO> res;


    public void askAllProduct() {
        //On va dire au ProductGateway que l'on souhaite récupérer la liste de tous les produits
        //Création du message et de la queue pour demander la liste de produits
        this.res=null;
        productGateway.askAllProduct();
    }

    @Override
    @Handler
    public void receiveAllProduct(OrderItemDTOContainer productDTOContainer) {
        this.res=productDTOContainer.getContainer();
    }

    @Override
    public Collection<OrderItemDTO> getAllProduct() {
        this.askAllProduct();
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
}
