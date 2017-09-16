package com;

public class Main {

    public static void main(String[] args) {
        System.out.println("task2");
        IAssemblyLineImpl iAssemblyLine = new IAssemblyLineImpl(new ILSMotor(), new ILSChassis(),new ILSBody());
        Car car = (Car)iAssemblyLine.assembleProduct(new Car());
        if (car != null) {
            System.out.println("car is assembled!");
        }
    }
}
