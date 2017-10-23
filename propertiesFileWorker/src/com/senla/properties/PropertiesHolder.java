package com.senla.properties;

public class PropertiesHolder {

    private int staleTime;
    private boolean automaticallyExecuteRequest;
    private String csvPath;

    public String getCsvPath() {
        return csvPath;
    }

    public void setCsvPath(String serializablePath) {
        this.csvPath = serializablePath;
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
