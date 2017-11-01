package com.senla.dependencyinjection;

import com.senla.dependencyinjection.annotation.ConfigProperty;

public class C {

    @ConfigProperty(type = ConfigProperty.Type.INT)
    int anInt;

    @ConfigProperty(type = ConfigProperty.Type.STRING)
    String anSting;

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String getAnSting() {
        return anSting;
    }

    public void setAnSting(String anSting) {
        this.anSting = anSting;
    }
}
