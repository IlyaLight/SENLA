package com.senla.server;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class Response implements Serializable{

    private Object resut;
    private InvocationTargetException exception;

    public Response() {
    }

    public Response(Object resut) {
        this.resut = resut;
    }

    public Response( InvocationTargetException exception) {
        this.exception = exception;
    }

    public Object getResut() {
        return resut;
    }

    public void setResut(Object resut) {
        this.resut = resut;
    }

    public InvocationTargetException getException() {
        return exception;
    }

    public void setException(InvocationTargetException exception) {
        this.exception = exception;
    }
}
