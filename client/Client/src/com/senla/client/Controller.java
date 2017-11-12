package com.senla.client;

import com.senla.client.exception.ObjectAvailabilityException;
import com.senla.client.model.Book;
import com.senla.client.model.Order;
import com.senla.client.model.Request;

import java.util.Date;
import java.util.List;

public class Controller implements IController {

    private Client client = new Client();

    @Override
    public List<Book> getBooksSortedByName() {
        return null;
    }

    @Override
    public List<Book> getBooksSortedByDateIssue() {
        return null;
    }

    @Override
    public List<Book> getBooksSortedByStockAvailability() {
        return null;
    }

    @Override
    public List<Book> getBooksSortedByPrice() {
        return null;
    }

    @Override
    public List<Book> getStaleBooksDate() {
        return null;
    }

    @Override
    public List<Book> getStaleBooksPrice(Date date) {
        return null;
    }

    @Override
    public List<Order> getOrderSortedByPrice() {
        return null;
    }

    @Override
    public List<Order> getOrderSortedByStatus() {
        return null;
    }

    @Override
    public List<Order> getOrderSortedByDataCompletion() {
        return null;
    }

    @Override
    public List<Order> getOrderSortedById() {
        return null;
    }

    @Override
    public Order getCloneOrderById(int id) throws ObjectAvailabilityException {
        return null;
    }

    @Override
    public List<Order> getCompletedOrder(Date from, Date to) {
        return null;
    }

    @Override
    public List<Order> getCompletedOrderSortedByPrice(Date from, Date to) {
        return null;
    }

    @Override
    public List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to) {
        return null;
    }

    @Override
    public List<Request> getRequestSortedByBookName() {
        return null;
    }

    @Override
    public List<Request> getRequestSortedOfQuantity() {
        return null;
    }

    @Override
    public String getBookDescription(String bookName) throws ObjectAvailabilityException {
        return null;
    }

    @Override
    public String getOrderDetails(Integer ip) throws ObjectAvailabilityException {
        return null;
    }

    @Override
    public void setBookQuantity(String bookName, int quantity) throws ObjectAvailabilityException {

    }

    @Override
    public float getIncome(Date from, Date to) {
        return 0;
    }

    @Override
    public void addOrder(Order order) {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void assembleOrder(Order order) {

    }

    @Override
    public void cancelTheOrder(Order order) {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void addRequest(Book book) {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public List<Request> findRequestByBookName(String name) {
        return null;
    }

    @Override
    public void readFromFileAllStore(String filePath) {

    }

    @Override
    public void writeToFile(String filePath) {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public Book GetBookByName(String name) throws ObjectAvailabilityException {
        return null;
    }

    @Override
    public Order getOrderById(Integer ip) throws ObjectAvailabilityException {
        return null;
    }

    @Override
    public void writeSerializable() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void readSerializable() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void exportAllStores() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[0].getMethodName()));
    }

    @Override
    public void exportBookStore() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void exportOrderStore() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void exportRequestStore() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void importAllStores() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void importBookStore() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void importOrderStore() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Override
    public void importRequestStore() {
        client.writeCommand(new com.senla.server.Command(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }
}
