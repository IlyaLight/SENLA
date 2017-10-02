package com.senla.booksshop.servis;

import com.senla.booksshop.model.Request;
import com.senla.booksshop.servis.comparator.RequestBookNameComparator;
import com.senla.booksshop.servis.comparator.RequestNumberRequestComparator;

import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class RequestSorter {

    //по имени
    public static void getRequstSortedByBookName(List<Request> requestArrayList) {
        Collections.sort(requestArrayList, new RequestBookNameComparator());
    }

    //по количество запросов
    public static void getRequstSortedNumberOfRequst(List<Request> requestArrayList) {
        Collections.sort(requestArrayList, new RequestNumberRequestComparator());
    }
}
