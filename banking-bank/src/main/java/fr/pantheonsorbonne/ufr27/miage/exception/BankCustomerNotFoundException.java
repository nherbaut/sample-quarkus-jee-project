package fr.pantheonsorbonne.ufr27.miage.exception;

public class BankCustomerNotFoundException extends Throwable{
    public BankCustomerNotFoundException() {
            super("No customer found ");
        }

}
