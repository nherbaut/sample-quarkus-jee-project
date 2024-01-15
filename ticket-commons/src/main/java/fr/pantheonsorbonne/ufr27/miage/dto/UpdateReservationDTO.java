package fr.pantheonsorbonne.ufr27.miage.dto;

public class UpdateReservationDTO {
    private String bookingReservationId;
    private String reservationStatus;

    public String getBookingReservationId() {
        return bookingReservationId;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setBookingReservationId(String bookingReservationId) {
        this.bookingReservationId = bookingReservationId;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public UpdateReservationDTO(String bookingReservationId, String reservationStatus) {
        this.bookingReservationId = bookingReservationId;
        this.reservationStatus = reservationStatus;
    }
}
