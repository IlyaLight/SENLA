package com.senla.booksshop.service.comparator;

import com.senla.api.model.Order;

import java.util.Comparator;

public class OrderIdComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        if(o1 == null || o2 == null)
        {
            return NullCompareFoComparators.compare(o1,o2);
        }
        return new Integer(o1.getId()).compareTo(o2.getId());
    }
}
