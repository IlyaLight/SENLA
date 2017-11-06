package com.senla.dependencyinjection;

import com.senla.dependencyinjection.annotation.Injection;

public class B implements IB {

    @Injection
    IA ia;

    @Override
    public IA getIa() {
        return ia;
    }

    @Override
    public void setIa(IA ia) {
        this.ia = ia;
    }
}
