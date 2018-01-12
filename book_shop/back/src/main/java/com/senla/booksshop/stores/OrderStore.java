package com.senla.booksshop.stores;

import com.senla.api.model.Order;
import com.senla.booksshop.dao.api.IOrderDao;
import dependencyinjection.annotation.Injection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class OrderStore implements IOrderStore {

    private static final String ERROR = "Error:";

    private static final long serialVersionUID = 655110329357559954L;
    private List<Order> orderList = new ArrayList<>();
    @Injection
    private IOrderDao orderDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderStore.class);


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
            orderDao.create(order);
    }

    @Override
    public Order read(int id){
            return (Order) orderDao.getByPK(id);
    }

    @Override
    public void update(Order order){
            orderDao.update(order);
    }

    @Override
    public void delete(Order order){
            orderDao.delete(order);
    }

}
