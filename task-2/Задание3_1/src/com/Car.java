package com;

/**
 * Created by Light on 16.09.2017.
 */
public class Car implements IProduct {
    protected Motor motor;
    protected Chassis chassis;
    protected Body body;
    Car(){
        System.out.println("new Car");
    }

    @Override
    public void installFirstPart(IProductPart iProductPart) {
       motor = (Motor)iProductPart;
        System.out.println("installFirstPart");
    }

    @Override
    public void installSecondPart(IProductPart iProductPart) {
        chassis = (Chassis)iProductPart;
        System.out.println("installSecondPart");
    }

    @Override
    public void installThridPart(IProductPart iProductPart) {
        body = (Body)iProductPart;
        System.out.println("installThridPart");
    }
}
