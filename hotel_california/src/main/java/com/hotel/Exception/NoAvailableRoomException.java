package com.hotel.Exception;

public class NoAvailableRoomException extends Throwable {
    public NoAvailableRoomException(){
        super("No rooms available");
    }
}
