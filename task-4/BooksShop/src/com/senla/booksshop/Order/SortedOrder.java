package com.senla.booksshop.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

/**
 * Created by Light on 24.09.2017.
 */
public class SortedOrder {

    public SortedOrder() {
    }

    public SortedOrder(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    private ArrayList<Order> orderArrayList;

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public TreeSet<Order> getOrderSortedByPrice() {
        TreeSet<Order> treeSet = new TreeSet<>(new OrderPriceComparator());
        treeSet.addAll(orderArrayList);
        return treeSet;
    }

    public TreeSet<Order> getOrderSortedByStatus() {
        TreeSet<Order> treeSet = new TreeSet<>(new OrderStatusComparator());
        treeSet.addAll(orderArrayList);
        return treeSet;
    }

    public TreeSet<Order> getOrderSortedByDataComplection() {
        TreeSet<Order> treeSet = new TreeSet<>(new OrderDateCompletionComparator());
        treeSet.addAll(orderArrayList);
        return treeSet;
    }

    public ArrayList<Order> getOrderSortedByCompletedData(Date from, Date to){
        ArrayList<Order> completedOrders = new ArrayList<>();
        for (Order order : orderArrayList) {
            if (order.isCompleted()
                    && order.getDataCompletion().compareTo(from) >= 0
                    && order.getDataCompletion().compareTo(to) <= 0){
                completedOrders.add(order);
            }
        }
        return completedOrders;
    }

    public TreeSet<Order> getOrderSortedByCompletedDatePrice(Date from, Date to){
        ArrayList<Order> completedOrders = getOrderSortedByCompletedData(from, to);
        Comparator<Order> comparator = new OrderDateCompletionComparator().thenComparing(new OrderPriceComparator());
        TreeSet<Order> sortedTS = new TreeSet<>(comparator);
        sortedTS.addAll(completedOrders);
        return sortedTS;
    }

}
