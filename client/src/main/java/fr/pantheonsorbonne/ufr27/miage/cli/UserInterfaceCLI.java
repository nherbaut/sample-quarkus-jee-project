package fr.pantheonsorbonne.ufr27.miage.cli;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import org.beryx.textio.TextIO;

import java.util.function.BiConsumer;

public interface UserInterfaceCLI extends BiConsumer<TextIO, RunnerData>, UserInterface {

    void askForLoggin();

    void displayProducts();

    void askForAction();

    void askForProductID();

    void createOrder(String productId);

    void addProduct(String productId);

    void deleteProduct(String productId);

    void deleteOrder();

    void askForClientId();

    void connectClient(String clientId);
    
    void initPayment();
}
