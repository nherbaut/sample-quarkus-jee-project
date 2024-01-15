package fr.pantheonsorbonne.ufr27.miage.dto;

public class ReservationResponseDTO {


    private Integer reservationId;
    private boolean success;
    private double totalPrice;
    private String hotelName;
    private String bookingReservationId;

    public ReservationResponseDTO(Integer reservationId, boolean success, double totalPrice, String hotelName, String bookingReservationId) {
        this.reservationId = reservationId;
        this.success = success;
        this.totalPrice = totalPrice;
        this.hotelName = hotelName;
        this.bookingReservationId = bookingReservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getBookingReservationId() {
        return bookingReservationId;
    }

    public void setBookingReservationId(String bookingReservationId) {
        this.bookingReservationId = bookingReservationId;
    }
}
