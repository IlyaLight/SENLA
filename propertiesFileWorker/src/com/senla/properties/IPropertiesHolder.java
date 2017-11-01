package com.senla.properties;

public interface IPropertiesHolder {
    String getCsvPath();

    void setCsvPath(String serializablePath);

    int getStaleTime();

    void setStaleTime(int staleTime);

    boolean isAutomaticallyExecuteRequest();

    void setAutomaticallyExecuteRequest(boolean automaticallyExecuteRequest);
}
