package com.senla.booksshop.stores;

import com.senla.api.model.Order;
import com.senla.booksshop.dao.DaoFactory;
import com.senla.booksshop.dao.GenericDao;
import com.senla.booksshop.dao.PersistException;
import com.senla.dependencyinjection.annotation.Injection;
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
    private DaoFactory daoFactory;
    private GenericDao genericDao = daoFactory.getDao(this.getClass());

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
        try {
            genericDao.persist(order);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order read(int id){
        try {
            return (Order)genericDao.getByPK(id);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Order order){
        try {
            genericDao.update(order);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Order order){
        try {
            genericDao.delete(order);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getOrders(String options){
        try {
            return genericDao.get(options);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }
}
