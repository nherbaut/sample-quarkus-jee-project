package fr.pantheonsorbonne.ufr27.miage.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import fr.pantheonsorbonne.ufr27.miage.dao.NoSuchTicketException;
import fr.pantheonsorbonne.ufr27.miage.dto.*;
import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ExpiredTransitionalTicketException;
import fr.pantheonsorbonne.ufr27.miage.exception.UnsuficientQuotaForVenueException;
import fr.pantheonsorbonne.ufr27.miage.model.Location;
import fr.pantheonsorbonne.ufr27.miage.model.Ticket;
import fr.pantheonsorbonne.ufr27.miage.model.Vendor;
import fr.pantheonsorbonne.ufr27.miage.model.Venue;
import fr.pantheonsorbonne.ufr27.miage.service.BookingService;
import fr.pantheonsorbonne.ufr27.miage.service.TicketingService;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
class TicketResourceTest {

    @Inject
    DBPopulation pop;

    @Inject
    BookingService bookingService;
    @Inject
    TicketingService ticketingService;


    TestData testData;

    @BeforeEach
    @Transactional
    public void setup() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        testData = pop.createMaterial();
    }


    @Test

    void isTicketValid() throws UnsuficientQuotaForVenueException, NoSuchTicketException, ExpiredTransitionalTicketException, CustomerNotFoundException.NoSeatAvailableException {

        Booking booking = bookingService.book(new Booking(testData.vendor().getId(), testData.venue().getId(), 1, 0));
        Integer transitionalTicket = booking.getStandingTransitionalTicket().stream().findAny().orElseThrow();
        TicketEmissionData ticketEmissionData = ticketingService.emitTicket(new ETicket(TicketType.FREE, 0, 0, "tot@gmail.com", "toto", "titi", transitionalTicket));
        TicketValidationDataDTO ticketValidationDataDTO = new TicketValidationDataDTO(transitionalTicket, testData.venue().getId(), testData.vendor().getId(), ticketEmissionData.salt(), ticketEmissionData.verifCode());
        TicketValidationDataDTO ticketValidationDataDTOBoggus = new TicketValidationDataDTO(transitionalTicket, 1, 1, ticketEmissionData.salt() + 1, ticketEmissionData.verifCode());


        given()
                .contentType("application/json")
                .body(ticketValidationDataDTO)
                .when()
                .post("ticket/validity")
                .then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .body(ticketValidationDataDTOBoggus)
                .when()
                .post("ticket/validity")
                .then()
                .statusCode(422);
    }
}