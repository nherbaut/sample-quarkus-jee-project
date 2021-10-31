package top.nextnet;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.io.IOException;

@ApplicationScoped
public class BookingGateway {

    @Inject
    CamelContext context;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.vendorId")
    Integer vendorId;

    public void sendBookingOrder(int standingCount, int seatingCount, int venueId) {
        try (ProducerTemplate producer = context.createProducerTemplate()) {
            producer.sendBody("direct:cli", new Booking(vendorId, venueId, seatingCount, standingCount));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
