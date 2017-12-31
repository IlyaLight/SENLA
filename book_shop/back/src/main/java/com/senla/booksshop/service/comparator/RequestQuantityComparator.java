package com.senla.booksshop.service.comparator;

import com.senla.api.model.Request;

import java.util.Comparator;

public class RequestQuantityComparator implements Comparator<Request> {

    @Override
    public int compare(Request o1, Request o2) {
        if(o1 == null || o2 == null)
        {
            return NullCompareFoComparators.compare(o1,o2);
        }
        if (o1.getQuantity() > o1.getQuantity()){
            return 1;
        }
        else if (o1.getQuantity() < o1.getQuantity()){
            return -1;
        }
        return 0;
    }
}
