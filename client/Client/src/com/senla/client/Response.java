package com.senla.client;

import java.io.Serializable;

public class Response implements Serializable {

    private Object resut;
    private Exception exception;

    public Response() {
    }

    public Response(Object resut) {
        this.resut = resut;
    }

    public Response( Exception e) {
        this.exception = e;
    }


    public Object getResut() {
        return resut;
    }

    public void setResut(Object resut) {
        this.resut = resut;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
