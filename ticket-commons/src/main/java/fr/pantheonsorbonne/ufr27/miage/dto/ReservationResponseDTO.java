package fr.pantheonsorbonne.ufr27.miage.dto;

public class ReservationResponseDTO {


    private Integer reservationId;
    private boolean success;

    public ReservationResponseDTO(Integer reservationId, boolean success) {
        this.reservationId = reservationId;
        this.success = success;
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
}
