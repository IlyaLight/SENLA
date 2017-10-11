package com.senla.booksshop.controller;

import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.model.Request;
import com.senla.booksshop.stores.BookStore;
import com.senla.booksshop.stores.OrderStore;
import com.senla.booksshop.stores.RequestStore;

import java.util.Date;
import java.util.List;

public interface IController {
    BookStore getBookStore();

    void setBookStore(BookStore bookStore);

    OrderStore getOrderStore();

    void setOrderStore(OrderStore orderStore);

    RequestStore getRequestStore();

    void setRequestStore(RequestStore requestStore);

    List<Book> getBooksSortedByName();

    List<Book> getBooksSortedByDateIssue();

    List<Book> getBooksSortedByStockAvailability();

    List<Book> getBooksSortedByPrice();

    List<Book> getStaleBooksDate(Date date);

    List<Book> getStaleBooksPrice(Date date);

    List<Order> getOrderSortedByPrice();

    List<Order> getOrderSortedByStatus();

    List<Order> getOrderSortedByDataCompletion();

    List<Order> getCompletedOrder(Date from, Date to);

    List<Order> getCompletedOrderSortedByPrice(Date from, Date to);

    List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to);

    List<Request> getRequestSortedByBookName();

    List<Request> getRequestSortedOfQuantity();

    String getBookDescription(String bookName);

    String getOrderDetails(Integer ip);

    void setBookAsQuantity(String bookName, int quantity);

    float getIncome(Date from, Date to);

    void addOrder(List<Book> books, Integer id);

    void assembledAnOrder(Order order);

    void cancelTheOrder(Order order);

    void addRequest(Book book);

    void readFromFile(String filePath);

    void writeToFile(String filePath);

    Book findBookByName(String name);

    Order getOrderById(Integer ip);
}
