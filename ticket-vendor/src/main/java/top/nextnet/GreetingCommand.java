package top.nextnet;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import picocli.CommandLine.Command;

import javax.inject.Inject;

@Command(name = "greeting", mixinStandardHelpOptions = true)
public class GreetingCommand implements Runnable {


    @Inject
    BookingGateway producer;

    @Inject
    ECommerce eCommerce;

    @Override
    public void run() {


        TextIO textIO = TextIoFactory.getTextIO();
        eCommerce.accept(textIO, new RunnerData(""));


    }

}
