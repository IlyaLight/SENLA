package com.senla.booksshop.servis.comparator;

import com.senla.booksshop.model.Order;

import java.util.Comparator;

public class OrderDateCompletionComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getDataCompletion().compareTo(o2.getDataCompletion());
    }
}
