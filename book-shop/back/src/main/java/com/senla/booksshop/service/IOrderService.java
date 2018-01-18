package com.senla.booksshop.service;

import com.senla.api.model.Order;

import java.util.Date;
import java.util.List;

public interface IOrderService {
    List<Order> getOrderSortedByPrice();

    List<Order> getOrderSortedByStatus();

    List<Order> getOrderSortedByDataCompletion();

    List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to);

    List<Order> getCompletedOrderSortedByPrice(Date from, Date to);

    List<Order> getCompletedOrder(Date from, Date to);

    String getOrderDetails(Integer id);

    Order getOrderById(int id);

    List<Order> getOrderSortedById();

    void create(Order order);


}
