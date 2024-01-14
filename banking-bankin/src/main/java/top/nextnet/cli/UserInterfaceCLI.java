package top.nextnet.cli;

import org.beryx.textio.TextIO;
import fr.pantheonsorbonne.ufr27.miage.dto.User;
import top.nextnet.model.Bank;

import java.util.function.BiConsumer;


public interface UserInterfaceCLI extends BiConsumer<TextIO, RunnerData>, UserInterface {

    User getUserInfoToBankin();
    User getUserInfoForBank(String bankName);
    Bank getUserBank();
    void displayUserOptions(top.nextnet.model.User user);
}


