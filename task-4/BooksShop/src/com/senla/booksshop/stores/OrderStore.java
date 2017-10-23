package com.senla.booksshop.stores;

import com.senla.booksshop.model.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class OrderStore implements Serializable {

    private List<Order> orderList = new ArrayList<>();

    public OrderStore() {
    }

    public OrderStore(List<Order> orders) {
        this.orderList = orders;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void create(Order order){
        orderList.add(order);
    }

    public void read(int id){
        System.out.println("Will be later");
    }

    public void update(Order order){

    }

    public void delete(int id){
        System.out.println("Will be later");
    }
}
