package com.hotel.Exception;

public class NoAvailableReservationException extends Throwable{
    public NoAvailableReservationException(){
        super("The Reservation is not found");
    }
}
