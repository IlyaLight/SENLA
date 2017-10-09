package com.senla.booksshop.servis;

import com.senla.booksshop.model.Request;
import com.senla.booksshop.servis.comparator.RequestBookNameComparator;
import com.senla.booksshop.servis.comparator.RequestQuantityComparator;

import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class RequestServis {

    public static final RequestBookNameComparator REQUEST_BOOK_NAME_COMPARATOR = new RequestBookNameComparator();
    public static final RequestQuantityComparator REQUEST_QUANTITY_COMPARATOR =
            new RequestQuantityComparator();

    public static List<Request> getRequstSortedByBookName(List<Request> requestArrayList) {
        List<Request> requests = new ArrayList<>(requestArrayList);
        Collections.sort(requests, REQUEST_BOOK_NAME_COMPARATOR);
        return requests;
    }

    public static List<Request> getRequstSortedOfquantity(List<Request> requestArrayList) {
        List<Request> requests = new ArrayList<>(requestArrayList);
        Collections.sort(requests, REQUEST_QUANTITY_COMPARATOR);
        return requests;
    }
}
