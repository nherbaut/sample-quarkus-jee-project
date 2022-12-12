package fr.pantheonsorbonne.ufr27.miage.exception;

public class ItemNotFoundException extends Throwable {
    public ItemNotFoundException(int itemId) {
        super("No item :" + itemId + "found ");
    }
}

