package com.senla.booksshop.sorted;

import com.senla.booksshop.objekt.Order;

import java.util.Comparator;

class OrderDateCompletionComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getDataCompletion().compareTo(o2.getDataCompletion());
    }
}
