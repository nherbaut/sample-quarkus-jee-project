package fr.pantheonsorbonne.ufr27.miage.cli;


import fr.pantheonsorbonne.ufr27.miage.resource.FidelityResource;
import fr.pantheonsorbonne.ufr27.miage.resource.OrderResource;
import fr.pantheonsorbonne.ufr27.miage.resource.ProductResource;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;


@ApplicationScoped
public class UserInterfaceCLIImpl implements UserInterfaceCLI {

    // TODO getTotalPrice

    @Inject
    @RestClient
    OrderResource orderResource;

    @Inject
    @RestClient
    ProductResource productResource;

    @Inject
    @RestClient
    FidelityResource fidelityResource;

    TextTerminal<?> terminal;
    TextIO textIO;

    Integer orderId;

    @Override
    public void askForLoggin() {
        terminal.println("Do you want to connect ? ");
    }

    @Override
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
       Response res = orderResource.createOrder(Integer.parseInt(productId));
       String orderId = res.getHeaderString("location").substring(res.getHeaderString("location").length()-1);
       this.orderId = Integer.parseInt(orderId);
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
        this.orderId = null;
        terminal.println("Your order is deleted !");
    }

    @Override
    public void askForClientId() {
        terminal.println("What is your client id ? ");
    }

    @Override
    public void connectClient(String clientId) {
        fidelityResource.connect(Integer.parseInt(clientId));
    }
    
    public void initPayment() {
        Response res = orderResource.payment(this.orderId);
        terminal.println("See the following link to pay : " + res.toString());
        // TODO display the link properly
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
