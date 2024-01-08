package fr.pantheonsorbonne.ufr27.miage.exception;

public class BankCustomerNotFoundException extends Exception{

    public static class NoFoundCustomerException extends Throwable {
        public NoFoundCustomerException() {
            super("No customer found ");
        }
    }
}
