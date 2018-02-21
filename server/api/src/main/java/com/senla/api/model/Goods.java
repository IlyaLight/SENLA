package com.senla.api.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class {@code Goods} contains parameters describing the goods
 *
 * @author Ilya Hailov
 * @since 1.00
 */
public class Goods {
    private Long id;
    private String name;
    private String group;
    private String description;
    private String characteristics;
    private BigDecimal price;
    private Integer inStock;
    private List<Car> suitableCaras;

}
