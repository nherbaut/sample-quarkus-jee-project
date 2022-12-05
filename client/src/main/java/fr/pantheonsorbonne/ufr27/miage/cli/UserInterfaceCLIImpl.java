package fr.pantheonsorbonne.ufr27.miage.cli;


import fr.pantheonsorbonne.ufr27.miage.resource.EmployeeService;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


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
        terminal.println("Products = " + employeeService.getAllProduct().toString());
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
