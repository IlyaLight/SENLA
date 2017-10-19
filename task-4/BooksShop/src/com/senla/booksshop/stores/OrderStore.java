package com.senla.booksshop.stores;

import com.senla.booksshop.model.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class OrderStore implements Serializable {

    private List<Order> orderArrayList = new ArrayList<>();

    public List<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public void setOrderArrayList(List<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public void create(){
        System.out.println("Will be later");
    }

    public void read(){
        System.out.println("Will be later");
    }

    public void update(Order order){
        orderArrayList.add(order);
    }

    public void delete(){
        System.out.println("Will be later");
    }
}
