package com.senla.booksshop.servis.comparator;

import com.senla.booksshop.model.Request;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RequestQuantityComparator implements Comparator<Request> {

    @Override
    public int compare(Request o1, Request o2) {
        if (o1.getQuantity() > o1.getQuantity()){
            return 1;
        }
        else if (o1.getQuantity() < o1.getQuantity()){
            return -1;
        }
        return 0;
    }
}
