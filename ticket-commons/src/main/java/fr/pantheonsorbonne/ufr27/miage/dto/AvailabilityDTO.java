package fr.pantheonsorbonne.ufr27.miage.dto;

import java.time.LocalDate;

public class AvailabilityDTO {

    private Integer roomId;
    private LocalDate from, to;

    public AvailabilityDTO(Integer roomId, LocalDate from, LocalDate to) {
        this.roomId = roomId;
        this.from = from;
        this.to = to;
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
}
