package com.senla.annotation;

public class A {

    @ConfigProperty()
    public int intTest;

    @ConfigProperty(configName = "configName", propertyName = "propertyName", type = ConfigProperty.Type.STRING)
    public String stringTest;


}
