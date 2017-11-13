package com.senla.client;

import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.model.Request;
import com.senla.client.exception.ObjectAvailabilityException;

import java.util.Date;
import java.util.List;

public interface IController {

    void stopClient();

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

    String getBookDescription(String bookName) throws ObjectAvailabilityException;

    String getOrderDetails(Integer ip) throws ObjectAvailabilityException;

    void setBookQuantity(String bookName, int quantity) throws ObjectAvailabilityException;

    float getIncome(Date from, Date to);

    void addOrder(Order order);

    void assembleOrder(Order order);

    void cancelTheOrder(Order order);

    void addRequest(Book book);

    List<Request> findRequestByBookName(String name);

    void readFromFileAllStore(String filePath);

    void writeToFile(String filePath);

    Book GetBookByName(String name) throws ObjectAvailabilityException;

    Order getOrderById(Integer ip) throws ObjectAvailabilityException;

    void writeSerializable();

    void readSerializable();

    void exportAllStores();

    void exportBookStore();

    void exportOrderStore();

    void exportRequestStore();

    void importAllStores();

    void importBookStore();

    void importOrderStore();

    void importRequestStore();

}
