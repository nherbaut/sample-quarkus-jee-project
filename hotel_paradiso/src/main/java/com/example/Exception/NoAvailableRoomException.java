package com.example.Exception;

public class NoAvailableRoomException extends Throwable {
    public NoAvailableRoomException(){
        super("The room is not available");
    }
}
