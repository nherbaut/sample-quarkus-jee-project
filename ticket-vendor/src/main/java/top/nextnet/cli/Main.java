package top.nextnet.cli;

import fr.pantheonsorbonne.ufr27.miage.dto.Booking;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import picocli.CommandLine.Command;
import top.nextnet.service.BookingGateway;


import javax.inject.Inject;

@Command(name = "greeting", mixinStandardHelpOptions = true)
public class Main implements Runnable {


    @Inject
    UserInterfaceCLI eCommerce;

    @Inject
    BookingGateway bookingGateway;

    @Override
    public void run() {


        TextIO textIO = TextIoFactory.getTextIO();
        eCommerce.accept(textIO, new RunnerData(""));


        while (true) {
            try {
                eCommerce.displayAvailableGigsToCli();
                Booking booking = eCommerce.getBookingFromOperator();
                bookingGateway.sendBookingOrder(booking.getStandingTicketsNumber(), booking.getSeatingTicketsNumber(), booking.getVenueId());
            } catch (Exception e) {
                eCommerce.showErrorMessage(e.getMessage());
            }
        }


    }

}
