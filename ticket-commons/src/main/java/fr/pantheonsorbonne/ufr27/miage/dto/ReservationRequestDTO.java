package fr.pantheonsorbonne.ufr27.miage.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationRequestDTO{
    private UserDTO user;
    private LocalDate from, to;
    private List<String> optionsNames = new ArrayList<>();

    private String bookingReservationId;

    private Integer guests;

    public ReservationRequestDTO() {
    }

    public ReservationRequestDTO(UserDTO user, LocalDate from, LocalDate to, List<String> optionsNames, String bookingReservationId, Integer guests) {
        this.user = user;
        this.from = from;
        this.to = to;
        this.optionsNames = optionsNames;
        this.bookingReservationId = bookingReservationId;
        this.guests = guests;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public void setOptionsNames(List<String> optionsNames) {
        this.optionsNames = optionsNames;
    }

    public void setBookingReservationId(String bookingReservationId) {
        this.bookingReservationId = bookingReservationId;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public UserDTO getUser() {
        return user;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public List<String> getOptionsNames() {
        return optionsNames;
    }

    public String getBookingReservationId() {
        return bookingReservationId;
    }

    public Integer getGuests() {
        return guests;
    }
}
