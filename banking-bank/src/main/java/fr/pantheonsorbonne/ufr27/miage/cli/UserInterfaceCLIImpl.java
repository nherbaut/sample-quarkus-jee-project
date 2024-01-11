package fr.pantheonsorbonne.ufr27.miage.cli;



import fr.pantheonsorbonne.ufr27.miage.dto.User;
import jakarta.enterprise.context.ApplicationScoped;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.eclipse.microprofile.config.inject.ConfigProperty;


import java.awt.*;



@ApplicationScoped
public class UserInterfaceCLIImpl implements UserInterfaceCLI {
    TextTerminal<?> terminal;
    TextIO textIO;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.bankName")
    String bankName;

    public User getUserInfoToBank(){
        terminal.println("Welcome to "+bankName+" bank !");

        String email = textIO.newStringInputReader().read("Your email ?");
        String password = textIO.newStringInputReader().withInputMasking(true).read("Your password ?");

        return new User(email,password);
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
