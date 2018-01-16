package com.senla.api;

import java.io.Serializable;

public class Response implements Serializable{

    private String result;


    private boolean exception;


    public Response() {
    }

    public Response(String result) {
        this.result = result;
    }

    public Response(String result , boolean exception) {
        this.result = result;
        this.exception = exception;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isException() {
        return exception;
    }

    public void setException(boolean exception) {
        this.exception = exception;
    }
}