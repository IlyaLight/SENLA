package com.senla.booksshop.service;

import com.senla.api.model.Order;
import com.senla.booksshop.service.comparator.OrderDateCompletionComparator;
import com.senla.booksshop.service.comparator.OrderIdComparator;
import com.senla.booksshop.service.comparator.OrderPriceComparator;
import com.senla.booksshop.service.comparator.OrderStatusComparator;

import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class OrderService {

    private static final OrderPriceComparator orderPriceComparator = new OrderPriceComparator();
    private static final OrderStatusComparator orderStatusComparator = new OrderStatusComparator();
    private static final OrderDateCompletionComparator orderDateCompletionComparator = new OrderDateCompletionComparator();
    private static final OrderIdComparator orderIdComparator = new OrderIdComparator();
    private static final String WITHOUT_DETAILS = "without details";

    public static List<Order> getOrderSortedByPrice(List<Order> orderArrayList) {
        List<Order> orderList = new ArrayList<>(orderArrayList);
       orderList.sort(orderPriceComparator);
       return orderList;
    }

    public static List<Order> getOrderSortedByStatus(List<Order> orderArrayList) {
        List<Order> orderList = new ArrayList<>(orderArrayList);
        orderList.sort(orderStatusComparator);
        return orderList;
    }

    public static List<Order> getOrderSortedByDataCompletion(List<Order> orderArrayList) {
        List<Order> orderList = new ArrayList<>(orderArrayList);
        orderList.sort(orderDateCompletionComparator);
        return orderList;
    }

    public static List<Order> getCompletedOrderSortedByCompletedData(List<Order> orderArrayList, Date from, Date to){
        return getOrderSortedByPrice(getCompletedOrder(orderArrayList, from, to));
    }

    public static List<Order> getCompletedOrderSortedByPrice(List<Order> orderArrayList, Date from, Date to){
        return getOrderSortedByPrice(getCompletedOrder(orderArrayList, from, to));
    }

    public static List<Order> getCompletedOrder(List<Order> orderArrayList, Date from, Date to){
        ArrayList<Order> completedOrders = new ArrayList<>();
        for (Order order : orderArrayList) {
            if (order.isCompleted()
                    && order.getDataCompletion().compareTo(from) >= 0
                    && order.getDataCompletion().compareTo(to) <= 0){
                completedOrders.add(order);
            }
        }
        return  completedOrders;
    }

    public static String getOrderDetails(List<Order> orderList, Integer id){
        Order order = getOrderById( orderList, id);
       if (order == null){
           return null;
       }else if(order.getDetails() == null){
           return WITHOUT_DETAILS;
       }else {
           return order.getDetails();
       }
    }

    public static Order getOrderById(List<Order> orderList, int id) {
        for (Order order : orderList) {
            if (order.getId() == id){
                return order;
            }
        }
        return null;
    }

    public static List<Order> getOrderSortedById(List<Order> orderArrayList) {
        List<Order> orderList = new ArrayList<>(orderArrayList);
        orderList.sort(orderIdComparator);
        return orderList;
    }
}
