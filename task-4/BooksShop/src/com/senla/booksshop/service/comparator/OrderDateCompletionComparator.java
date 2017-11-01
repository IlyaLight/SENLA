package com.senla.booksshop.service.comparator;

import com.senla.booksshop.model.Order;

import java.util.Comparator;

public class OrderDateCompletionComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        if(o1 == null || o2 == null)
        {
            return NullCompareFoComparators.compare(o1,o2);
        }
        return o1.getDataCompletion().compareTo(o2.getDataCompletion());
    }
}
