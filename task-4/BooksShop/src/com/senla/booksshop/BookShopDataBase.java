package com.senla.booksshop;

import com.senla.booksshop.Book.*;
import com.senla.booksshop.Order.Order;
import com.senla.booksshop.Order.OrderDateCompletionComparator;
import com.senla.booksshop.Order.OrderPriceComparator;
import com.senla.booksshop.Order.OrderStatusComparator;
import com.senla.booksshop.Request.Request;
import com.senla.booksshop.Request.RequestBookNameComparator;
import com.senla.booksshop.Request.RequestNumberRequestComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Light on 24.09.2017.
 */
public class BookShopDataBase {

    private ArrayList<Book> bookArrayList;
    private ArrayList<Order> orderArrayList;
    private ArrayList<Request> requestArrayList;

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public ArrayList<Request> getRequestArrayList() {
        return requestArrayList;
    }

    public void setRequestArrayList(ArrayList<Request> requestArrayList) {
        this.requestArrayList = requestArrayList;
    }

    public TreeSet<Book> getBooksSortedByName() {
        TreeSet<Book> treeSet = new TreeSet<>(new BookNameComparator());
        treeSet.addAll(bookArrayList);
        return treeSet;
    }

    public TreeSet<Book> getBooksSortedByPrice() {
        TreeSet<Book> treeSet = new TreeSet<>(new BookPriceComparator());
        treeSet.addAll(bookArrayList);
        return treeSet;
    }

    public TreeSet<Book> getBooksSortedByDateIssue() {
        TreeSet<Book> treeSet = new TreeSet<>(new BookDateIssueComparator());
        treeSet.addAll(bookArrayList);
        return treeSet;
    }

    public TreeSet<Book> getBooksSortedByStockAvailability() {
        TreeSet<Book> treeSet = new TreeSet<>(new BookStockAvailabilityComparator());
        treeSet.addAll(bookArrayList);
        return treeSet;
    }

    public TreeSet<Order> getOrderSortedByPrice() {
        TreeSet<Order> treeSet = new TreeSet<>(new OrderPriceComparator());
        treeSet.addAll(orderArrayList);
        return treeSet;
    }

    public TreeSet<Order> getOrderSortedByStatus() {
        TreeSet<Order> treeSet = new TreeSet<>(new OrderStatusComparator());
        treeSet.addAll(orderArrayList);
        return treeSet;
    }

    public TreeSet<Order> getOrderSortedByDataComplection() {
        TreeSet<Order> treeSet = new TreeSet<>(new OrderDateCompletionComparator());
        treeSet.addAll(orderArrayList);
        return treeSet;
    }

    public TreeSet<Request> getRequstSortedByBookName() {
        TreeSet<Request> treeSet = new TreeSet<>(new RequestBookNameComparator());
        treeSet.addAll(requestArrayList);
        return treeSet;
    }

    public ArrayList<String> getRequstSortedNumberRequst() {
        HashMap<String, Integer> map = new HashMap<>();
        String bookName;
        for (Request request : requestArrayList) {
            bookName = request.getBookName();
            if (map.containsKey(bookName)){
                map.put(bookName, map.get(bookName) + 1);
            }
            else {
                map.put(bookName, 1);
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(new RequestNumberRequestComparator(map));
        treeMap.putAll(map);
        ArrayList<String> sortedarray = new ArrayList<>();
        for (String request : treeMap.keySet()) {
            sortedarray.add(request);
        }
        return sortedarray;
    }


}
