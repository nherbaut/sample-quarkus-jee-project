package fr.pantheonsorbonne.ufr27.miage.exception;

public class ExpiredTransitionalTicketException extends Throwable {

    private final int expiredTicketId;

    public ExpiredTransitionalTicketException(int expiredTicketId) {
        this.expiredTicketId = expiredTicketId;
    }

    public int getExpiredTicketId() {
        return this.expiredTicketId;
    }
}
