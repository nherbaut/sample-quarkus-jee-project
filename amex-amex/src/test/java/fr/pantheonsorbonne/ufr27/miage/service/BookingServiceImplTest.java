package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.*;
import fr.pantheonsorbonne.ufr27.miage.dto.Booking;
import fr.pantheonsorbonne.ufr27.miage.exception.UnsuficientQuotaForVenueException;
import fr.pantheonsorbonne.ufr27.miage.model.Ticket;
import fr.pantheonsorbonne.ufr27.miage.model.Vendor;
import fr.pantheonsorbonne.ufr27.miage.model.Venue;
import fr.pantheonsorbonne.ufr27.miage.model.VenueQuota;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @InjectMocks
    BookingServiceImpl bookingService;
    @Mock
    VenueQuotaDAO venueQuotaDAO;
    @Mock
    VenueDAO venueDAO;
    @Mock
    VendorDAO vendorDAO;
    @Mock
    TicketDAO ticketDAO;
    final int[] ticketId = {0};
    private Collection<Integer> standingTransitionalTicker;

    private Collection<Integer> seatingTransitionalTicker;

    @BeforeEach
    public void setup() {
        lenient().when(venueQuotaDAO.getMatchingQuota(eq(1), eq(1), ArgumentMatchers.intThat(arg -> arg <= 1), ArgumentMatchers.intThat(arg -> arg <= 1))).thenReturn(new VenueQuota(null, 1, 1));
        lenient().doThrow(NoResultException.class).when(venueQuotaDAO).getMatchingQuota(eq(1), eq(1), ArgumentMatchers.intThat(arg -> arg > 1), ArgumentMatchers.intThat(arg -> arg > 1));
        lenient().when(venueDAO.findById(eq(1))).thenReturn(new Venue(1, Collections.EMPTY_LIST, null, LocalDate.now()));
        lenient().when(vendorDAO.findById(eq(1))).thenReturn(new Vendor(1, "fnac"));
        lenient().when(ticketDAO.save(any(), any(), any())).thenAnswer((Answer<Ticket>) invocationOnMock -> new Ticket(++ticketId[0]));

        standingTransitionalTicker = new ArrayList<>();
        seatingTransitionalTicker = new ArrayList<>();
    }

    @Test
    void bookVoid() throws UnsuficientQuotaForVenueException, NoSuchTicketException {


        bookingService.book(new Booking(1, 1, 0, 0, standingTransitionalTicker, seatingTransitionalTicker));
        verify(ticketDAO, never()).save(any(), any(), any());


    }

    @Test
    void bookOneStanding() throws UnsuficientQuotaForVenueException, NoSuchTicketException {


        bookingService.book(new Booking(1, 1, 1, 0, standingTransitionalTicker, seatingTransitionalTicker));
        verify(ticketDAO, times(1)).save(any(), any(), any());
        assertEquals(1, standingTransitionalTicker.size());
        assertEquals(0, seatingTransitionalTicker.size());


    }

    @Test
    void bookOneSeating() throws UnsuficientQuotaForVenueException, NoSuchTicketException {


        bookingService.book(new Booking(1, 1, 0, 1, standingTransitionalTicker, seatingTransitionalTicker));
        verify(ticketDAO, times(1)).save(any(), any(), any());
        assertEquals(0, standingTransitionalTicker.size());
        assertEquals(1, seatingTransitionalTicker.size());

    }

    @Test
    void bookNotEnough() throws UnsuficientQuotaForVenueException {

        assertThrows(UnsuficientQuotaForVenueException.class, () -> bookingService.book(new Booking(1, 1, 99, 99, standingTransitionalTicker, seatingTransitionalTicker)));
    }
}