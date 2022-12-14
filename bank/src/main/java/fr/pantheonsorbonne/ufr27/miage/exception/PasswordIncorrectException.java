package fr.pantheonsorbonne.ufr27.miage.exception;

public class PasswordIncorrectException extends Throwable {
    public PasswordIncorrectException(int password) {
        super("The password " + password + " is incorrect please try again ! ");
    }
}

