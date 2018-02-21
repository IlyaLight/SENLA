package com.senla.api.model;

import java.util.List;

/**
 * Class {@code Car} serves to describe the specific model of the car
 * to which parts will be attached
 *
 * @author Ilya Hailov
 * @since 1.00
 */

public class Car {
    /** Id **/
    private Long Id;
    /** Brand **/
    private String brand;
    /** Model **/
    private String model;
    /** Year **/
    private Integer year;
    /** Type of fuel **/
    private String typeOfFuel;
    /** Engine capacity **/
    private Integer engineCapacity;
    /** Suitable goods **/
    private List<Goods> suitableGoods;
}
