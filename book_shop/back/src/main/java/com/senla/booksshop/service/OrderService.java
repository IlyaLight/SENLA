package com.senla.booksshop.service;

import com.senla.api.model.Order;
import com.senla.booksshop.dao.api.IOrderDao;
import com.senla.booksshop.dao.realization.jdbc.MySqlOrderDao;
import com.senla.booksshop.stores.IOrderStore;
import com.senla.dependencyinjection.annotation.Injection;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class OrderService {

    private static final String WITHOUT_DETAILS = "without details";

    private static final SimpleDateFormat dateFormat = new  SimpleDateFormat("'yyyy-MM-dd'");

    @Injection
    private IOrderStore requestOrder;
    @Injection
    private IOrderDao orderDao;

    public  List<Order> getOrderSortedByPrice() {
        return orderDao.getAll(MySqlOrderDao.PRICE);
    }

    public  List<Order> getOrderSortedByStatus() {
        return orderDao.getAll(MySqlOrderDao.STATUS);
    }

    public  List<Order> getOrderSortedByDataCompletion() {
        return orderDao.getAll(MySqlOrderDao.DATA_COMPLETION);
    }

    public  List<Order> getCompletedOrderSortedByCompletedData( Date from, Date to){
        return orderDao .getCompletedOrder(from, to, MySqlOrderDao.DATA_COMPLETION);
    }

    public  List<Order> getCompletedOrderSortedByPrice(Date from, Date to){
        return orderDao .getCompletedOrder(from, to, MySqlOrderDao.PRICE);
    }

    public  List<Order> getCompletedOrder(Date from, Date to){
        return orderDao .getCompletedOrder(from, to, MySqlOrderDao.ID);
    }

    public  String getOrderDetails(Integer id){
        Order order = requestOrder.read(id);
       if (order == null){
           return null;
       }else if(order.getDetails() == null){
           return WITHOUT_DETAILS;
       }else {
           return order.getDetails();
       }
    }

    public  Order getOrderById(int id) {
        return requestOrder.read(id);
    }

    public List<Order> getOrderSortedById() {
        return orderDao.getAll(MySqlOrderDao.ID);
    }
}
