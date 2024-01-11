package fr.pantheonsorbonne.ufr27.miage.exception;

public class BankAccountNotFoundException extends Throwable{

    public BankAccountNotFoundException(){
        super("No account found");
    }
}
