package fr.pantheonsorbonne.ufr27.miage.cli;

import fr.pantheonsorbonne.ufr27.miage.dto.OrderDTO;
import org.beryx.textio.TextIO;

import javax.ws.rs.core.Response;
import java.util.function.BiConsumer;

public interface UserInterfaceCLI extends BiConsumer<TextIO, RunnerData>, UserInterface {

    void askForLoggin();
    void displayProducts();
    void askForAction();
    void askForProductToAddFirst();

    void createOrder(String productId);

    OrderDTO displayOrder(OrderDTO orderCreated);
}
