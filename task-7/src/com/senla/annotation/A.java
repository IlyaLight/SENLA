package com.senla.annotation;

public class A {

    @ConfigProperty(type = ConfigProperty.Type.INT)
    private int intTest;

    @ConfigProperty(configName = "config.properties", propertyName = "A.stringTest", type = ConfigProperty.Type.STRING)
    private String stringTest;

    private int noAnnotation;

    public int getIntTest() {
        return intTest;
    }

    public void setIntTest(int intTest) {
        this.intTest = intTest;
    }

    public String getStringTest() {
        return stringTest;
    }

    public void setStringTest(String stringTest) {
        this.stringTest = stringTest;
    }

    public int getNoAnnotation() {
        return noAnnotation;
    }

    public void setNoAnnotation(int noAnnotation) {
        this.noAnnotation = noAnnotation;
    }
}
