package fr.pantheonsorbonne.ufr27.miage.exception;

public class MaximumBonusPointsReachedException extends Throwable{

    public MaximumBonusPointsReachedException(int client_id) {
        super("Cannot add more bonus points to : " + client_id + "Account !");
    }
}
