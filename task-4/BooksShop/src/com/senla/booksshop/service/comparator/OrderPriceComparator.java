package com.senla.booksshop.service.comparator;

import com.senla.booksshop.model.Order;

import java.util.Comparator;

public class OrderPriceComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        if(o1 == null || o2 == null)
        {
            return NullCompareFoComparators.compare(o1,o2);
        }
        if(o1.getPrice()> o2.getPrice()){
            return 1;
        }
        if(o1.getPrice()< o2.getPrice()){
            return -1;
        }
        return 0;

    }
}
