package com.senla.booksshop.utility;


import com.senla.dependencyinjection.annotation.ConfigProperty;

public class PropertiesHolder
{
    @ConfigProperty(type = int.class)
    private int staleTime;

    @ConfigProperty(type = boolean.class)
    private boolean automaticallyExecuteRequest;

    @ConfigProperty(type = String.class)
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
