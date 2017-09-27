package com.senla.booksshop;

import com.senla.booksshop.objekt.*;
import com.senla.booksshop.objekt.Request;
import com.senla.booksshop.sorted.SortedBook;
import com.senla.booksshop.sorted.SortedOrder;
import com.senla.booksshop.sorted.SortedRequest;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Light on 22.09.2017.
 */
public class Shop {

    private SortedOrder sortedOrder;
    private SortedRequest sortedRequest;
    private SortedBook sortedBook;

    public Shop() {
    }

    public Shop(SortedOrder sortedOrder, SortedRequest sortedRequest, SortedBook sortedBook) {
        this.sortedOrder = sortedOrder;
        this.sortedRequest = sortedRequest;
        this.sortedBook = sortedBook;
    }

    public SortedOrder getSortedOrder() {
        return sortedOrder;
    }

    public void setSortedOrder(SortedOrder sortedOrder) {
        this.sortedOrder = sortedOrder;
    }

    public SortedRequest getSortedRequest() {
        return sortedRequest;
    }

    public void setSortedRequest(SortedRequest sortedRequest) {
        this.sortedRequest = sortedRequest;
    }

    public SortedBook getSortedBook() {
        return sortedBook;
    }

    public void setSortedBook(SortedBook sortedBook) {
        this.sortedBook = sortedBook;
    }

    public void setBookAsAvailab(Book book){
        book.setInStock(true);
        ArrayList<Request> requestArrayList = sortedRequest.getRequestArrayList();
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

