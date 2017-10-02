package com.senla.booksshop.stores;

import com.senla.booksshop.model.Order;
import java.util.ArrayList;


/**
 * Created by Light on 27.09.2017.
 */
public class OrderCollection {

    private ArrayList<Order> orderArrayList = new ArrayList<Order>();

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public void create(){}

    public void read(){}

    public void update(){}

    public void delete(){}
}
