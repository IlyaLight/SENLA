package com.senla.api;

import java.io.Serializable;

public class Command implements Serializable {
    private String methodName;
    private Object[] params;

    public Command() {
    }

    public Command(String methodName) {
        this.methodName = methodName;
    }

    public Command(String methodName, Object[] params) {
        this.methodName = methodName;
        this.params = params;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

}

