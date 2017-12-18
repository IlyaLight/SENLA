package com.senla.booksshop.stores;

import com.senla.api.model.Order;
import com.senla.booksshop.dao.PersistException;

import java.io.Serializable;
import java.util.List;

public interface IOrderStore extends Serializable {
    List<Order> getOrderList();

    void setOrderList(List<Order> orderList);

    void create(Order order);

    Order read(int id);

    void update(Order order) ;

    void delete(Order order);

    List<Order> getOrders(String options);
}
