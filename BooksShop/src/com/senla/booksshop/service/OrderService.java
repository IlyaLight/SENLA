package com.senla.booksshop.service;

import com.senla.api.model.Order;
import com.senla.booksshop.service.comparator.OrderDateCompletionComparator;
import com.senla.booksshop.service.comparator.OrderIdComparator;
import com.senla.booksshop.service.comparator.OrderPriceComparator;
import com.senla.booksshop.service.comparator.OrderStatusComparator;
import com.senla.booksshop.stores.IOrderStore;
import com.senla.booksshop.stores.IRequestStore;
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

    public  List<Order> getOrderSortedByPrice() {
        return requestOrder.getOrders(" ORDER BY price ASC ;");
    }

    public  List<Order> getOrderSortedByStatus() {
        return requestOrder.getOrders(" ORDER BY status ASC ;");
    }

    public  List<Order> getOrderSortedByDataCompletion() {
        return requestOrder.getOrders(" ORDER BY data_completion ASC ;");
    }

    public  List<Order> getCompletedOrderSortedByCompletedData( Date from, Date to){
        return requestOrder.getOrders(" WHERE date_issue > " +dateFormat.format(from)+ " AND date_issue < "  +dateFormat.format(to)+  " AND completed = TRUE ORDER BY data_completion ASC ;");
    }

    public  List<Order> getCompletedOrderSortedByPrice(Date from, Date to){
        return requestOrder.getOrders(" WHERE date_issue > " +dateFormat.format(from)+ " AND date_issue < "  +dateFormat.format(to)+  " AND completed = TRUE ORDER BY price ASC ;");
    }

    public  List<Order> getCompletedOrder(Date from, Date to){
        return requestOrder.getOrders(" WHERE date_issue > " +dateFormat.format(from)+ " AND date_issue < "  +dateFormat.format(to)+ " AND completed = TRUE ORDER BY data_completion ASC ;");
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
        return requestOrder.getOrders(" ORDER BY id ASC ;");
    }
}
