package com.senla.dependencyinjection;

public class Main {

    public static void main(String[] args) {
        System.out.println(A.class.getName());
       IB b = (IB)DIFactoriControllers.getController(IB.class);

       System.out.println(b);
       System.out.println(b.getIa());
       System.out.println(b.getIa().getC().anInt);
       System.out.println(b.getIa().getC().anSting);
    }
}
