package com;

/**
 * Created by Light on 16.09.2017.
 */
public class ILSMotor implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.print("buildProductPart");
        return new Motor();
    }
}
