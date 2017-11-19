package com.senla.booksshop.stores;

import com.senla.api.model.Order;
import com.senla.booksshop.utility.IdUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class OrderStore implements IOrderStore {

    private static final long serialVersionUID = 655110329357559954L;
    private List<Order> orderList = new ArrayList<>();

    public OrderStore() {
    }

    public OrderStore(List<Order> orders) {
        this.orderList = orders;
    }

    @Override
    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public void create(Order order){
        order.setId(IdUtil.getId(orderList));
        orderList.add(order);
    }

    @Override
    public void read(int id){
        System.out.println("Will be later");
    }

    @Override
    public void update(Order order){
        System.out.println("Will be later");
    }

    @Override
    public void delete(int id){
        System.out.println("Will be later");
    }
}
