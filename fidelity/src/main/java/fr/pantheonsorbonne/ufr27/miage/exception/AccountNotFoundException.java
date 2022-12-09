package fr.pantheonsorbonne.ufr27.miage.exception;

public class AccountNotFoundException extends Throwable{

        public AccountNotFoundException(int client_id) {super("No account found for client : " + client_id);}

}
