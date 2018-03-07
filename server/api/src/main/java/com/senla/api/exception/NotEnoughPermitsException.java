package com.senla.api.exception;

public class NotEnoughPermitsException extends Exception{
    public NotEnoughPermitsException(Exception e) {
        super(e);
    }

    public NotEnoughPermitsException() {
    }

    public NotEnoughPermitsException(String message) {
        super(message);
    }
}
