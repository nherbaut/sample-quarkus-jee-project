package fr.pantheonsorbonne.ufr27.miage.cli;


import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import fr.pantheonsorbonne.ufr27.miage.resource.EmployeeService;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;


@ApplicationScoped
public class UserInterfaceCLIImpl implements UserInterfaceCLI {

    @Inject
    @RestClient
    EmployeeService employeeService;

    TextTerminal<?> terminal;
    TextIO textIO;

    @Override
    public void askForLoggin() {
        terminal.println("Do you want to connect ? ");
    }

    public void displayProducts(){
        terminal.println("Products = \n" + employeeService.getAllProduct());
    }

    @Override
    public void askForAction() {
        terminal.println("What de you want to do ? (add, delete, end) ");
    }

    @Override
    public void askForProductToAddFirst() {
        terminal.println("Can you tell me the id of the product you want ?");
    }

    @Override
    public void createOrder(String productId) {
        terminal.println((List<String>) employeeService.createOrder(Integer.parseInt(productId)));
        //displayOrder(res);
    }

    @Override
    public OrderDTO displayOrder(OrderDTO orderCreated) {
        terminal.println("Votre commande : " + orderCreated.toString());
        return orderCreated;
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
