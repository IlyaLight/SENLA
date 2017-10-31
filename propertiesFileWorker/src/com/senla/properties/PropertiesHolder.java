package com.senla.properties;


import com.senla.annotation.ConfigProperty;

public class PropertiesHolder implements IPropertiesHolder
{
    @ConfigProperty(type = ConfigProperty.Type.INT)
    private int staleTime;
    @ConfigProperty(type = ConfigProperty.Type.BOOLEAN)
    private boolean automaticallyExecuteRequest;
    @ConfigProperty(type = ConfigProperty.Type.STRING)
    private String csvPath;

    @Override
    public String getCsvPath() {
        return csvPath;
    }

    @Override
    public void setCsvPath(String serializablePath) {
        this.csvPath = serializablePath;
    }

    @Override
    public int getStaleTime() {
        return staleTime;
    }

    @Override
    public void setStaleTime(int staleTime) {
        this.staleTime = staleTime;
    }

    @Override
    public boolean isAutomaticallyExecuteRequest() {
        return automaticallyExecuteRequest;
    }

    @Override
    public void setAutomaticallyExecuteRequest(boolean automaticallyExecuteRequest) {
        this.automaticallyExecuteRequest = automaticallyExecuteRequest;
    }
}
