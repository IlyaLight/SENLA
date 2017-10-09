package com.senla.booksshop.servis;

import com.senla.booksshop.model.Order;
import com.senla.booksshop.servis.comparator.OrderDateCompletionComparator;
import com.senla.booksshop.servis.comparator.OrderPriceComparator;
import com.senla.booksshop.servis.comparator.OrderStatusComparator;

import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class OrderServis {

    private static final OrderPriceComparator orderPriceComparator = new OrderPriceComparator();
    private static final OrderStatusComparator orderStatusComparator = new OrderStatusComparator();
    private static final OrderDateCompletionComparator orderDateCompletionComparator = new OrderDateCompletionComparator();

    public static List<Order> getOrderSortedByPrice(List<Order> orderArrayList) {
        List<Order> orderList = new ArrayList<>(orderArrayList);
       Collections.sort(orderList, orderPriceComparator);
       return orderList;
    }

    public static List<Order> getOrderSortedByStatus(List<Order> orderArrayList) {
        List<Order> orderList = new ArrayList<>(orderArrayList);
        Collections.sort(orderList, orderStatusComparator);
        return orderList;
    }

    public static List<Order> getOrderSortedByDataComplection(List<Order> orderArrayList) {
        List<Order> orderList = new ArrayList<>(orderArrayList);
        Collections.sort(orderList, orderDateCompletionComparator);
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

    public static String getOrderDetails(List<Order> orderList, Integer ip){
        for (Order order : orderList) {
            if (order.getId().equals(ip)){
                return order.getDetails();
            }
        }
        return "not found";
    }
}
