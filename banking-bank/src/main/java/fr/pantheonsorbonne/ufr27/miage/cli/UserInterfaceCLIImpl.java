package fr.pantheonsorbonne.ufr27.miage.cli;

import fr.pantheonsorbonne.ufr27.miage.camel.TokenGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.User;
import fr.pantheonsorbonne.ufr27.miage.exception.TokenGenerationException;
import fr.pantheonsorbonne.ufr27.miage.service.CompteService;
import fr.pantheonsorbonne.ufr27.miage.service.CustomerService;
import fr.pantheonsorbonne.ufr27.miage.service.NotificationService;
import fr.pantheonsorbonne.ufr27.miage.service.TokenService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import fr.pantheonsorbonne.ufr27.miage.model.Customer;
import fr.pantheonsorbonne.ufr27.miage.model.Account;
import fr.pantheonsorbonne.ufr27.miage.model.Notification;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;

@ApplicationScoped
public class UserInterfaceCLIImpl implements UserInterfaceCLI {
    TextTerminal<?> terminal;
    TextIO textIO;

    @Inject
    NotificationService notificationService;
    @Inject
    CompteService compteService;
    @Inject
    CustomerService customerService;
    @Inject
    TokenService tokenService;

    @Inject
    TokenGateway tokenGateway;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.bankName")
    String bankName;

    public User getUserInfoToBank(){
        terminal.println("Welcome to "+bankName+" bank !");

        String email = textIO.newStringInputReader().read("Your email ?");
        String password = textIO.newStringInputReader().withInputMasking(true).read("Your password ?");

        return new User(email,password);
    }
    @Override
    public void userFunctionalities(User user){
        List<String> functionalityNames = new ArrayList<>();
        for (Functionality functionality : Functionality.values()) {
            functionalityNames.add(functionality.name().toLowerCase());
        }
        String f = textIO.newStringInputReader().withPossibleValues(functionalityNames).read("Select an option");

        if(f.equals(Functionality.NOTIFICATION.name().toLowerCase())){
            this.respondNotification(user);
        }
    }

    private void respondNotification(User user){
        Customer customer = customerService.findCustomer(user.getEmail());
        Account account = compteService.findAccount(customer.getIdCustomer());

        Collection<Notification> notif = notificationService.notificationAuthorisationAvailableForAnAccount(account.getIdAccount());

        if(notif != null){
            for(Notification n : notif){
                terminal.println(n.getTexte());
                String response = textIO.newStringInputReader().withPossibleValues(Arrays.asList("Yes", "No")).read("Select a response");
                if(response.equals("Yes")) {
                    try {
                        String token = tokenService.generateToken(user.getEmail());
                        tokenGateway.submitToken(user.getEmail(),bankName, token);
                        terminal.println("Token generated and sent: " + token); //pour voir la génération de token
                    } catch (Exception | TokenGenerationException e) {
                        terminal.println("Error generating token: " + e.getMessage());
                    }
                }
                terminal.println("Message sent !");
            }
        }else{
            terminal.println("Empty notification");
        }
    }

    @Override
    public void accept(TextIO textIO, RunnerData runnerData) {
        this.textIO = textIO;
        terminal = textIO.getTextTerminal();
   }

    @Override
    public void showErrorMessage(String errorMessage) {
        terminal.getProperties().setPromptColor(Color.RED);
        terminal.println(errorMessage);
        terminal.getProperties().setPromptColor(Color.white);
    }

    @Override
    public void showSuccessMessage(String s) {
        terminal.getProperties().setPromptColor(Color.GREEN);
        terminal.println(s);
        terminal.getProperties().setPromptColor(Color.white);
    }
}
