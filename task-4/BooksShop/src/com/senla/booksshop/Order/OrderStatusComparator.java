package com.senla.booksshop.Order;

import java.util.Comparator;

class OrderStatusComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2){
        return o1.getStatus().compareTo(o2.getStatus());
    }
}
