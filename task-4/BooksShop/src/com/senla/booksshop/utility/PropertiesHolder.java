package com.senla.booksshop.utility;

public class PropertiesHolder {

    private int staleTime;
    private boolean automaticallyExecuteRequest;
    private String serializablePath;

    public String getSerializablePath() {
        return serializablePath;
    }

    public void setSerializablePath(String serializablePath) {
        this.serializablePath = serializablePath;
    }

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
