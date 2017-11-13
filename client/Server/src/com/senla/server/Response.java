package com.senla.server;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class Response implements Serializable{

    private Object result;
    private InvocationTargetException exception;

    public Response() {
    }

    public Response(Object result) {
        this.result = result;
    }

    public Response( InvocationTargetException exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public InvocationTargetException getException() {
        return exception;
    }

    public void setException(InvocationTargetException exception) {
        this.exception = exception;
    }
}
