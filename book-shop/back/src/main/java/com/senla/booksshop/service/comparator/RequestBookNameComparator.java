package com.senla.booksshop.service.comparator;


import com.senla.api.model.Request;

import java.util.Comparator;

public class RequestBookNameComparator implements Comparator<Request> {
    @Override
    public int compare(Request o1, Request o2) {
        if(o1 == null || o2 == null)
        {
            return NullCompareFoComparators.compare(o1,o2);
        }
        return 0;//o1.getBookName().compareTo(o2.getBookName());
    }
}
