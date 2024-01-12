package top.nextnet.exception;

public class BankinAccountNotFoundException extends Throwable{
    public BankinAccountNotFoundException(){
        super("No bankin account found");
    }

}
