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

        TextIO textIO = TextIoFactory.getTextIO();
        client.accept(textIO, new RunnerData(""));

        client.displayProducts();

        while (true) {
        }

    }

}
