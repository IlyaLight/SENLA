package com.senla.dependencyinjection;

import com.senla.dependencyinjection.annotation.ContainsConfigProperty;

public class A implements IA {

    @ContainsConfigProperty
    public C c;

    @Override
    public C getC() {
        return c;
    }

    @Override
    public void setC(C c) {
        this.c = c;
    }
}
