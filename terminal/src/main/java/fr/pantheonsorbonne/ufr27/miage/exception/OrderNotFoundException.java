package fr.pantheonsorbonne.ufr27.miage.exception;

public class OrderNotFoundException extends Throwable {
    public OrderNotFoundException(int orderId) {
        super("No Order" + orderId + " found ");
    }
}

