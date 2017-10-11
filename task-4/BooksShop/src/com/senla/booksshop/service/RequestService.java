package com.senla.booksshop.service;

import com.senla.booksshop.model.Request;
import com.senla.booksshop.service.comparator.RequestBookNameComparator;
import com.senla.booksshop.service.comparator.RequestQuantityComparator;

import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class RequestService {

    private static final RequestBookNameComparator REQUEST_BOOK_NAME_COMPARATOR = new RequestBookNameComparator();
    private static final RequestQuantityComparator REQUEST_QUANTITY_COMPARATOR =
            new RequestQuantityComparator();

    public static List<Request> getRequestSortedByBookName(List<Request> requestArrayList) {
        List<Request> requests = new ArrayList<>(requestArrayList);
        requests.sort(REQUEST_BOOK_NAME_COMPARATOR);
        return requests;
    }

    public static List<Request> getRequestSortedOfquantity(List<Request> requestArrayList) {
        List<Request> requests = new ArrayList<>(requestArrayList);
        requests.sort(REQUEST_QUANTITY_COMPARATOR);
        return requests;
    }
}
