package com.senla.booksshop.controller;

import com.senla.booksshop.model.*;
import com.senla.booksshop.model.Request;
import com.senla.booksshop.servis.BookSorter;
import com.senla.booksshop.servis.OrderSorter;
import com.senla.booksshop.servis.RequestSorter;
import com.senla.booksshop.stores.BookCollection;
import com.senla.booksshop.stores.OrderCollection;
import com.senla.booksshop.stores.RequestCollection;
import com.senla.booksshop.utility.WorkWithFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Light on 22.09.2017.
 */
public class Shop {

    private BookCollection bookCollection ;
    private OrderCollection orderCollection;
    private RequestCollection requestCollection;

    public BookCollection getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(BookCollection bookCollection) {
        this.bookCollection = bookCollection;
    }

    public OrderCollection getOrderCollection() {
        return orderCollection;
    }

    public void setOrderCollection(OrderCollection orderCollection) {
        this.orderCollection = orderCollection;
    }

    public RequestCollection getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(RequestCollection requestCollection) {
        this.requestCollection = requestCollection;
    }

    public void setBookAsAvailab(Book book, int quantity){
        book.setInStock(quantity);
        List<Request> requestList = requestCollection.getRequestArrayList();
        if (quantity>0) {
            for (Request request : requestList) {
                if (request.getBookName().equals(book.getName())) {
                    request.setCompleted(true);
                }
            }
        }
    }

    public float getIncome(Date from, Date to){
        List<Order> orders = OrderSorter.getCompletedOrderSortedByCompletedData(orderCollection.getOrderArrayList(),from, to);
        float income = 0;
        for (Order order : orders) {
            income += order.getPrice();
        }
        return income;
    }

    public void readFromFile(final String filePath){
        bookCollection = new BookCollection();
        bookCollection.setBookList(WorkWithFile.readBooksFromFile(filePath));
        orderCollection = new OrderCollection();
        orderCollection.setOrderArrayList(WorkWithFile.readOrdersFromFile(filePath));
        requestCollection = new RequestCollection();
        requestCollection.setRequestArrayList(WorkWithFile.readRequestFromFile(filePath));
    }

    public void writeToFile(final String filePath){


        WorkWithFile.writeBooksToFile(filePath, bookCollection.getBookList());
        WorkWithFile.writeOrdersToFile(filePath, orderCollection.getOrderArrayList());
        WorkWithFile.writeRequestsToFile(filePath, requestCollection.getRequestArrayList());
    }
}

