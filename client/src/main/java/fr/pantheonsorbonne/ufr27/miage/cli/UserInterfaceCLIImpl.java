package fr.pantheonsorbonne.ufr27.miage.cli;


import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.resource.OrderResource;
import fr.pantheonsorbonne.ufr27.miage.resource.ProductResource;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class UserInterfaceCLIImpl implements UserInterfaceCLI {

    @Inject
    @RestClient
    OrderResource orderResource;

    @Inject
    @RestClient
    ProductResource productResource;

    TextTerminal<?> terminal;
    TextIO textIO;

    Integer orderId = 1;

    @Override
    public void askForLoggin() {
        terminal.println("Do you want to connect ? ");
    }

    public void displayProducts(){
        terminal.println("\n\nProducts = " + productResource.getAllProduct() + "\n");
    }

    @Override
    public void askForAction() {
        terminal.println("What de you want to do ? (add, delete, end) ");
    }

    @Override
    public void askForProductID() {
        terminal.println("Can you tell me the id of the product you want ?");
    }

    @Override
    public void createOrder(String productId) {
       orderResource.createOrder(Integer.parseInt(productId));
       terminal.println("success");
       // TODO trouver un moyen pour récupérer le header et notamment l'id de l'order
        // this.orderId = ...
    }

    @Override
    public void addProduct(String productId) {
        terminal.println("\n\nYour order : " + orderResource.addProduct(Integer.parseInt(productId), this.orderId) + "\n");
    }

    @Override
    public void deleteProduct(String productId) {
        terminal.println("\n\nYour order : " + orderResource.deleteProduct(Integer.parseInt(productId), this.orderId) + "\n");
    }

    @Override
    public void deleteOrder() {
        orderResource.deleterOrder(String.valueOf(this.orderId));
        terminal.println("Your order is deleted !");
    }

    @Override
    public String getCustomerResponse() {
        return this.textIO.newStringInputReader().read("Customer response");
    }

    @Override
    public void accept(TextIO textIO, RunnerData runnerData) {
        this.textIO = textIO;
        terminal = textIO.getTextTerminal();
   }

}
