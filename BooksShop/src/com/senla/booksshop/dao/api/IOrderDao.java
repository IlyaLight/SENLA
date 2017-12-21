package com.senla.booksshop.dao.api;

import com.senla.api.model.Order;

import java.util.Date;
import java.util.List;

public interface IOrderDao {

    void create(Order order) ;

    Order getByPK(int key) ;

    void  update(Order order) ;

    void delete(Order order) ;

    List<Order> getAll(String... sortingColumn);

    List<Order> getCompletedOrder(Date from, Date to, String sortingColumn);
}
