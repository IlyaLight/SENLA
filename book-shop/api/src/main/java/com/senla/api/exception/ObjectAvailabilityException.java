package com.senla.api.exception;

public class ObjectAvailabilityException extends Exception {

    public ObjectAvailabilityException(Exception e) {
        super(e);
    }

    public ObjectAvailabilityException() {
    }

    public ObjectAvailabilityException(String message) {
        super(message);
    }
}
