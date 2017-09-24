package com.senla.booksshop;

import com.senla.booksshop.Book.*;
import com.senla.booksshop.Order.*;
import com.senla.booksshop.Request.Request;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Light on 22.09.2017.
 */
public class Shop {

    private ArrayList<Book> bookArrayList;
    private ArrayList<Order> orderArrayList;
    private ArrayList<Request> requestArrayList;
    private SortedOrder sortedOrder;

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
                request.setCompleted(true);
            }
        }
    }

    public float getIncome(Date from, Date to){
        ArrayList<Order> orders = sortedOrder.getOrderSortedByCompletedData(from, to);
        float income = 0;
        for (Order order : orders) {
            income += order.getPrice();
        }
        return income;
    }
}

