package fr.pantheonsorbonne.ufr27.miage.exception;

public class CustomerNotFoundException extends Throwable {
    public CustomerNotFoundException(int idClient){
        super(idClient + "is not an Amex Client");
    }

}