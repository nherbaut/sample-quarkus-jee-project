package fr.pantheonsorbonne.ufr27.miage.exception;

public class ClientNotFoundException extends Throwable {
    public ClientNotFoundException(int clientId) {
        super("No Client " + clientId + " found ");
    }
}

