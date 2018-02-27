package com.senla.api.model;

import javax.persistence.*;

import java.util.List;

/**
 * Class {@code Car} serves to describe the specific model of the car
 * to which parts will be attached
 *
 * @author Ilya Hailov
 * @since 1.00
 */
@Entity
@Table(name = "car")
public class Car {

    /** Id **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    /** Brand **/
    @Column(name = "brand")
    private String brand;

    /** Model **/
    @Column(name = "model")
    private String model;

    /** Year **/
    @Column(name = "year")
    private Integer year;

    /** Type of fuel **/
    @Column(name = "type_of_fuel")
    private String typeOfFuel;

    /** Engine capacity **/
    @Column(name = "engine_capacity")
    private Integer engineCapacity;

    /** Suitable goods **/
    @ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY)
    private List<Goods> suitableGoods;

    /** list of buyers with such a machine **/
    @ManyToMany(mappedBy = "cars")
    private List<Person> persons;

}
