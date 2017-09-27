package com.senla.booksshop;

import com.senla.booksshop.objekt.Book;
import com.senla.booksshop.objekt.Order;
import com.senla.booksshop.objekt.Request;

import java.util.ArrayList;

/**
 * Created by Light on 24.09.2017.
 */
public class Data {
    public ArrayList<Order> loadFromFileOrders(){
        ArrayList<Order> orders = new ArrayList<>();
        return orders;
    }
    public ArrayList<Book> loadFromFileBooks(){
        ArrayList<Book> books = new ArrayList<>();
        return books;
    }
    public ArrayList<Request> loadFromFileRequests(){
        ArrayList<Request> requests = new ArrayList<>();
        return requests;
    }
}
