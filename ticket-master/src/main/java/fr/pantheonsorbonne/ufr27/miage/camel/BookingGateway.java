package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.Booking;
import fr.pantheonsorbonne.ufr27.miage.service.BookingService;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;


import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import javax.inject.Named;
import javax.jms.*;

@ApplicationScoped
public class BookingGateway {

    @Inject
    BookingService bookingService;

    public Booking book(Booking bookingRequest) {

        return bookingService.book(bookingRequest);
    }


}

