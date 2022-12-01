package fr.pantheonsorbonne.ufr27.miage.exception;

public class VillagerNotFoundException extends Exception{

    public static class NoVillagerAvailableException extends Throwable{
        public NoVillagerAvailableException(){
            super("No Villager available");
        }
    }
}
