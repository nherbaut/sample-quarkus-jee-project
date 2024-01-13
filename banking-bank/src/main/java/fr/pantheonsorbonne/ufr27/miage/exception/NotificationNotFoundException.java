package fr.pantheonsorbonne.ufr27.miage.exception;

public class NotificationNotFoundException extends Throwable{
    public NotificationNotFoundException(){
        super("No notification for the current user");
    }
}
