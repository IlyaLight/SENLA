package com.senla.api;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Book;
import com.senla.api.model.Order;
import com.senla.api.model.Request;

import java.util.Date;
import java.util.List;

public interface IController {

    List<Book> getBooksSortedByName();

    List<Book> getBooksSortedByDateIssue();

    List<Book> getBooksSortedByStockAvailability();

    List<Book> getBooksSortedByPrice();

    List<Book> getStaleBooksDate();

    List<Book> getStaleBooksPrice(Date date);

    List<Order> getOrderSortedByPrice();

    List<Order> getOrderSortedByStatus();

    List<Order> getOrderSortedByDataCompletion();

    List<Order> getOrderSortedById();

    Order getCloneOrderById(int id) throws ObjectAvailabilityException;

    List<Order> getCompletedOrder(Date from, Date to);

    List<Order> getCompletedOrderSortedByPrice(Date from, Date to);

    List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to);

    List<Request> getRequestSortedByBookName();

    List<Request> getRequestSortedOfQuantity();

    List<String> getBookDescription(String bookName) throws ObjectAvailabilityException;

    String getOrderDetails(Integer ip) throws ObjectAvailabilityException;

    void setBookQuantity(String bookName, int quantity) throws ObjectAvailabilityException;

    float getIncome(Date from, Date to);

    void addOrder(Order order);

    void assembleOrder(Order order);

    void cancelTheOrder(Order order);

    void addRequest(Book book);

    List<Request> findRequestByBookName(String name);

    List<Book> GetBookByName(String name);

    Order getOrderById(Integer ip) throws ObjectAvailabilityException;

}
