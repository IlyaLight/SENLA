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
import java.util.TreeSet;

/**
 * Created by Light on 22.09.2017.
 */
public class Shop {

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

    public void setBookAsAvailab(Book book){
        book.setStockAvailability(true);
        for (Request request : requestArrayList) {
            if (request.getBookName().equals(book.getName())){
                request.setAccomplished(true);
            }
        }
    }
}

