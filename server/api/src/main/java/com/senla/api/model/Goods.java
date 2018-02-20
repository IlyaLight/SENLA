package com.senla.api.model;

import java.math.BigDecimal;
import java.util.List;

public class Goods {
    private Long id;
    private String name;
    private String description;
    private String characteristics;
    private BigDecimal price;
    private Integer inStock;
    private List<Car> suitableCaras;

}
