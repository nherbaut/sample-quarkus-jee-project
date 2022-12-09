package fr.pantheonsorbonne.ufr27.miage.cli;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import picocli.CommandLine.Command;

import javax.inject.Inject;

@Command(name = "greeting", mixinStandardHelpOptions = true)
public class Main implements Runnable {

    @Inject
    UserInterfaceCLI client;

    @Override
    public void run() {

        String clientRes = "";

        TextIO textIO = TextIoFactory.getTextIO();
        client.accept(textIO, new RunnerData(""));

        client.askForLoggin();
        clientRes = client.getCustomerResponse();
        if (clientRes.equals("yes")){
            //Lancer la procédure de connexion
        }

        client.displayProducts();
        //Ajout du premier produit pour création de la commande
        client.askForProductToAddFirst();
        clientRes = client.getCustomerResponse();
        System.out.println(clientRes);
        client.createOrder(clientRes);

        do {
            client.displayProducts();
            //askForAction -- add, delete, end
            clientRes = client.getCustomerResponse();
        } while (!clientRes.equals("end"));

    }

}
