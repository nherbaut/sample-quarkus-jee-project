package fr.pantheonsorbonne.ufr27.miage.dto;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationRequestDTO {

    private Integer userId, roomId;
    private LocalDate from, to;
    private List<Integer> optionsId = new ArrayList<>();

    private String bookingReservationId;

    private Integer guests;

    public ReservationRequestDTO(){

    }
    public ReservationRequestDTO(Integer userId, Integer roomId, LocalDate from, LocalDate to, List<Integer> optionsId, Integer guests) {
        this.userId = userId;
        this.roomId = roomId;
        this.from = from;
        this.to = to;
        this.optionsId = optionsId;
        this.guests = guests;
    }

    public String getBookingReservationId() {
        return bookingReservationId;
    }

    public void setBookingReservationId(String bookingReservationId) {
        this.bookingReservationId = bookingReservationId;
    }

    public ReservationRequestDTO(Integer userId, Integer roomId, LocalDate from, LocalDate to, List<Integer> optionsId) {
        this.userId = userId;
        this.roomId = roomId;
        this.from = from;
        this.to = to;
        this.optionsId = optionsId;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public List<Integer> getOptionsId() {
        return optionsId;
    }

    public void setOptionsId(List<Integer> optionsId) {
        this.optionsId = optionsId;
    }
}
