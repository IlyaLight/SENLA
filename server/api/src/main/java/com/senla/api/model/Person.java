package com.senla.api.model;

import java.util.List;
import java.util.Map;

public class Person {
    private Long id;
    private String name;
    private String Status;
    private String mail;
    private List<Order> orders;
    private Cart cart;
    private List<Address> addresses;
    private Map<Long,Car> cars; //VIN,car
    private Long basicAddresId;
}
