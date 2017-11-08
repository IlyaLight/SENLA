package com.senla.booksshop.stores;

import com.senla.booksshop.model.Order;

import java.io.Serializable;
import java.util.List;

public interface IOrderStore extends Serializable {
    List<Order> getOrderList();

    void setOrderList(List<Order> orderList);

    void create(Order order);

    void read(int id);

    void update(Order order);

    void delete(int id);
}
