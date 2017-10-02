package com.senla.booksshop.servis.comparator;


import com.senla.booksshop.model.Request;

import java.util.Comparator;

public class RequestBookNameComparator implements Comparator<Request> {
    @Override
    public int compare(Request o1, Request o2) {
        return o1.getBookName().compareTo(o2.getBookName());
    }
}
