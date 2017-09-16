package com;

/**
 * Created by Light on 16.09.2017.
 */
public class IAssemblyLineImpl implements IAssemblyLine {
    private ILSMotor    ilsMotor;
    private ILSChassis  ilsChassis;
    private ILSBody     ilsBody;
    IAssemblyLineImpl(ILSMotor ilsMotor, ILSChassis ilsChassis, ILSBody ilsBody){
        this.ilsBody = ilsBody;
        this.ilsChassis = ilsChassis;
        this.ilsMotor = ilsMotor;
        System.out.println("new IAssemblyLineImpl");
    }
    @Override
    public IProduct assembleProduct(IProduct iProduct) {
        iProduct.installFirstPart(ilsMotor.buildProductPart());
        iProduct.installSecondPart(ilsChassis.buildProductPart());
        iProduct.installThridPart(ilsBody.buildProductPart());
        System.out.println("assembleProduct");
        return iProduct;
    }
}
