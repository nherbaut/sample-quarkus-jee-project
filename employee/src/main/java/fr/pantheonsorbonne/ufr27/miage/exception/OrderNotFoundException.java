package fr.pantheonsorbonne.ufr27.miage.exception;

public class OrderNotFoundException extends Throwable {
    public OrderNotFoundException() {
        super("No Order found ");
    }
}

