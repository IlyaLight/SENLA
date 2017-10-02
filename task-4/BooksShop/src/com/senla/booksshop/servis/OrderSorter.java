package com.senla.booksshop.servis;

import com.senla.booksshop.model.Order;
import com.senla.booksshop.servis.comparator.OrderDateCompletionComparator;
import com.senla.booksshop.servis.comparator.OrderPriceComparator;
import com.senla.booksshop.servis.comparator.OrderStatusComparator;

import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class OrderSorter {

    public static void getOrderSortedByPrice(List<Order> orderArrayList) {
        Collections.sort(orderArrayList, new OrderPriceComparator());
    }

    public static void getOrderSortedByStatus(List<Order> orderArrayList) {
        Collections.sort(orderArrayList, new OrderStatusComparator());
    }

    public static void getOrderSortedByDataComplection(List<Order> orderArrayList) {
        Collections.sort(orderArrayList, new OrderDateCompletionComparator());
    }

    public static List<Order> getCompletedOrderSortedByCompletedData(List<Order> orderArrayList, Date from, Date to){
        ArrayList<Order> completedOrders = new ArrayList<>();
        for (Order order : orderArrayList) {
            if (order.isCompleted()
                    && order.getDataCompletion().compareTo(from) >= 0
                    && order.getDataCompletion().compareTo(to) <= 0){
                completedOrders.add(order);
            }
        }
        getOrderSortedByDataComplection(completedOrders);
        return completedOrders;
    }

    public List<Order> getCompletedOrderSortedByPrice(List<Order> orderArrayList, Date from, Date to){
        ArrayList<Order> completedOrders = new ArrayList<>();
        for (Order order : orderArrayList) {
            if (order.isCompleted()
                    && order.getDataCompletion().compareTo(from) >= 0
                    && order.getDataCompletion().compareTo(to) <= 0){
                completedOrders.add(order);
            }
        }
        getOrderSortedByPrice(completedOrders);
        return completedOrders;
    }

}
