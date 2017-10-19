package com.senla.booksshop.utility;

public class PropertiesHolder {

    private int staleTime;
    private boolean automaticallyExecuteRequest;

    public int getStaleTime() {
        return staleTime;
    }

    public void setStaleTime(int staleTime) {
        this.staleTime = staleTime;
    }

    public boolean isAutomaticallyExecuteRequest() {
        return automaticallyExecuteRequest;
    }

    public void setAutomaticallyExecuteRequest(boolean automaticallyExecuteRequest) {
        this.automaticallyExecuteRequest = automaticallyExecuteRequest;
    }
}
