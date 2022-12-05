package fr.pantheonsorbonne.ufr27.miage.cli;

import org.beryx.textio.TextIO;

import java.util.function.BiConsumer;

public interface UserInterfaceCLI extends BiConsumer<TextIO, RunnerData>, UserInterface {

    void askForLoggin();
    void displayProducts();
}
