package com.senla.booksshop.dao.api;

import com.senla.api.model.Order;

import java.util.Date;
import java.util.List;

public interface IOrderDao extends IGenericDao<Order, Integer> {

    public static final String ID               = "id";
    public static final String PRICE            = "price";
    public static final String DATA_COMPLETION  = "data_completion";
    public static final String DETAILS          = "details";
    public static final String STATUS           = "status";
    public static final String COMPLETED        = "completed";
    public static final String TABLE            = "orders";

    List<Order> getAll(String sortingColumn);

    List<Order> getCompletedOrder(Date from, Date to, String sortingColumn);
}
