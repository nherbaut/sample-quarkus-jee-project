package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.Booking;
import fr.pantheonsorbonne.ufr27.miage.dto.Gig;
import fr.pantheonsorbonne.ufr27.miage.exception.UnsuficientQuotaForVenueException;
import fr.pantheonsorbonne.ufr27.miage.service.BookingService;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class VendorResourceTest {

    @Inject
    BookingService bookingService;

    @Inject
    DBPopulation pop;


    TestData testData;
    @BeforeEach
    @Transactional
    public void setup() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        pop.truncateAllTables();
        testData=pop.createMaterial();
    }



    @Test

    public void testGig() {
        Response response = given()
                .when()
                .get("vendor/" + testData.vendor().getId() + "/venues")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Gig[] gigs = response.as(Gig[].class);
        assertEquals(1, gigs.length);
        assertEquals("radiohead", gigs[0].getArtistName());
        assertEquals("Le Zenith", gigs[0].getLocation());

        given()
                .when()
                .get("vendor/" + 999999 + "/venues")
                .then()
                .statusCode(404);

    }
    @Inject
    EntityManager em;


    @Test

    public void testQuotas() {

        given()
                .when().get("vendor/" + testData.vendor().getId() + "/venue/" + testData.venue().getId() + "/quota")
                .then()
                .assertThat()
                .statusCode(200)
                .body("seating", equalTo(testData.quota().getSeatingQuota())
                        , "standing", equalTo(testData.quota().getStandingQuota()));


        assertDoesNotThrow(() -> bookingService.book(new Booking(testData.vendor().getId(), testData.venue().getId(), 1, 0)));



        given()
                .when().get("vendor/" + testData.vendor().getId() + "/venue/" + testData.venue().getId() + "/quota")
                .then()
                .assertThat()
                .statusCode(200)
                .body("seating", equalTo(testData.quota().getSeatingQuota())
                        , "standing", equalTo(testData.quota().getStandingQuota()-1));

        assertDoesNotThrow(() -> bookingService.book(new Booking(testData.vendor().getId(),  testData.venue().getId(), testData.quota().getStandingQuota()-1, testData.quota().getSeatingQuota())));

        given()
                .when().get("vendor/" + testData.vendor().getId() + "/venue/" + testData.venue().getId() + "/quota")
                .then()
                .assertThat()
                .statusCode(200)
                .body("seating", equalTo(0)
                        , "standing", equalTo(0));

        assertThrows(UnsuficientQuotaForVenueException.class, () -> bookingService.book(new Booking(testData.vendor().getId(), testData.venue().getId(), 1, 1)));
    }


}