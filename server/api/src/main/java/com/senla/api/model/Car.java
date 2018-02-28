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

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public List<Goods> getSuitableGoods() {
        return suitableGoods;
    }

    public void setSuitableGoods(List<Goods> suitableGoods) {
        this.suitableGoods = suitableGoods;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
