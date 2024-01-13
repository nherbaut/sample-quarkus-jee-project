package fr.pantheonsorbonne.ufr27.miage.exception;

public class NotificationFoundException extends Exception{
    public static class NotificationAuthorisationFoundException extends Throwable{
        public NotificationAuthorisationFoundException(){
            super("Request for synch already sent");
        }
    }
}
