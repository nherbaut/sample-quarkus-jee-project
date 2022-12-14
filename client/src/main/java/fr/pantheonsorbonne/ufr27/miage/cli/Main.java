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
            client.askForClientId();
            clientRes = client.getCustomerResponse();
            client.connectClient(clientRes);

        }

        client.displayProducts();
        //Ajout du premier produit pour création de la commande
        client.askForProductID();
        clientRes = client.getCustomerResponse();
        client.createOrder(clientRes);

        do {
            client.displayProducts();
            //askForAction -- add, delete, end
            client.askForAction();
            clientRes = client.getCustomerResponse();
            if (clientRes.equals("add")) {
                client.askForProductID();
                clientRes = client.getCustomerResponse();
                client.addProduct(clientRes);
            } else if (clientRes.equals("delete")) {
                client.askForProductID();
                clientRes = client.getCustomerResponse();
                client.deleteProduct(clientRes);
            } else if (clientRes.equals("abandon")) {
                client.deleteOrder();
            } else {
                //don't understand the res
            }
        } while (!clientRes.equals("end"));

        //Initier le paiement

        client.initPayment();

    }

}
