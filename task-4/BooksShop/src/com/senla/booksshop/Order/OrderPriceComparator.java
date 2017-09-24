package com.senla.booksshop.Order;

import java.util.Comparator;

public class OrderPriceComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        if(o1.getPrice()> o2.getPrice()){
            return 1;
        }
        if(o1.getPrice()< o2.getPrice()){
            return -1;
        }
        return 0;

    }
}
