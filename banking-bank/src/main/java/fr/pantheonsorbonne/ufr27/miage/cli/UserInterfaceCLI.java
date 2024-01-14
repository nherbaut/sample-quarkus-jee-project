package fr.pantheonsorbonne.ufr27.miage.cli;

import fr.pantheonsorbonne.ufr27.miage.dto.User;
import org.apache.camel.Body;
import org.apache.camel.Header;
import org.beryx.textio.TextIO;

import java.util.function.BiConsumer;

public interface UserInterfaceCLI extends BiConsumer<TextIO, RunnerData>, UserInterface {

    User getUserInfoToBank();
    void userFunctionalities(User user);
    void processAuthorizationRequest(@Body String jsonBody, @Header("bankId") int bankId);
}
