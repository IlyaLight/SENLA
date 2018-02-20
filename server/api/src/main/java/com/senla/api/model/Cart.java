package com.senla.api.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Cart {
    private Long id;
    private Map<Goods,Integer> goods;   //goods and quantity
    private BigDecimal totalPrice;
    private Person person;
}
