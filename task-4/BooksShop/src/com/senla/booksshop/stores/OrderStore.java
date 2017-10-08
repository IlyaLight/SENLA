package com.senla.booksshop.stores;

import com.senla.booksshop.model.Order;
import java.util.ArrayList;


/**
 * Created by Light on 27.09.2017.
 */
public class OrderStore {

    private ArrayList<Order> orderArrayList = new ArrayList<Order>();

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public void create(){
        System.out.println("Will be later");
    }

    public void read(){
        System.out.println("Will be later");
    }

    public void update(){
        System.out.println("Will be later");
    }

    public void delete(){
        System.out.println("Will be later");
    }
}
