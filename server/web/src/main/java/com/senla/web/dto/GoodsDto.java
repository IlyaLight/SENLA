package com.senla.web.dto;

import com.senla.api.model.Car;

import javax.validation.constraints.NotNull;
import java.util.List;

public class GoodsDto {

    @NotNull
    private Car car;

    @NotNull
    private List<Long> carsId;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Long> getCarsId() {
        return carsId;
    }

    public void setCarsId(List<Long> carsId) {
        this.carsId = carsId;
    }
}
