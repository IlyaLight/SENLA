package com.senla.booksshop.utility;


import com.senla.dependencyinjection.annotation.ConfigProperty;

public class PropertiesHolder
{
    @ConfigProperty(type = ConfigProperty.Type.INT)
    private int staleTime;

    @ConfigProperty(type = ConfigProperty.Type.BOOLEAN)
    private boolean automaticallyExecuteRequest;

    @ConfigProperty(type = ConfigProperty.Type.STRING)
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
