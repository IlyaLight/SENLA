package com.senla.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class Order {
    private Long id;
    private Map<Goods,Integer> goods;   //goods and quantity
    private BigDecimal totalPrice;
    private Person person;
    private LocalDate orderDate;
    private String orderDetails;
    private Address address;
}
