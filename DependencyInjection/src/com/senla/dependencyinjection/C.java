package com.senla.dependencyinjection;

import com.senla.dependencyinjection.annotation.ConfigProperty;

public class C {

    @ConfigProperty(type = int.class)
    int anInt;

    @ConfigProperty(type = String.class)
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
