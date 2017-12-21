package com.senla.properties;

public class PropertyNotFoundException extends Exception{
    public PropertyNotFoundException() {
    }

    public PropertyNotFoundException(String message) {
        super(message);
    }
}
