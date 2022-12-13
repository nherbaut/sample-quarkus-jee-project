package fr.pantheonsorbonne.ufr27.miage.exception;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(int productId) {
        super("No product :" + productId + "found ");
    }
}

