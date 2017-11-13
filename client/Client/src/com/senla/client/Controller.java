package com.senla.client;

import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.model.Request;
import com.senla.client.exception.ObjectAvailabilityException;
import com.senla.server.Response;

import java.util.Date;
import java.util.List;


public class Controller implements IController {

    private Client client = new Client();

    @Override
    public List<Book> getBooksSortedByName() {
       return (List<Book>) writeCommand().getResut();
    }

    @Override
    public List<Book> getBooksSortedByDateIssue() {
        return (List<Book>) writeCommand().getResut();
    }

    @Override
    public List<Book> getBooksSortedByStockAvailability() {
        return (List<Book>) writeCommand().getResut();
    }

    @Override
    public List<Book> getBooksSortedByPrice() {
        return (List<Book>) writeCommand().getResut();
    }

    @Override
    public List<Book> getStaleBooksDate() {
        return (List<Book>) writeCommand().getResut();
    }

    @Override
    public List<Book> getStaleBooksPrice(Date date) {
        return (List<Book>) writeCommand(date).getResut();
    }

    @Override
    public List<Order> getOrderSortedByPrice() {
        return (List<Order>) writeCommand().getResut();
    }

    @Override
    public List<Order> getOrderSortedByStatus() {
        return (List<Order>) writeCommand().getResut();
    }

    @Override
    public List<Order> getOrderSortedByDataCompletion() {
        return (List<Order>) writeCommand().getResut();
    }

    @Override
    public List<Order> getOrderSortedById() {
        return (List<Order>) writeCommand().getResut();
    }

    @Override
    public Order getCloneOrderById(int id) throws ObjectAvailabilityException {
        return (List<Order>) writeCommand(id).getResut();
    }

    @Override
    public List<Order> getCompletedOrder(Date from, Date to) {
        return (List<Order>) writeCommand(from, to).getResut();
    }

    @Override
    public List<Order> getCompletedOrderSortedByPrice(Date from, Date to) {
        return (List<Order>) writeCommand(from, to).getResut();
    }

    @Override
    public List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to) {
        return (List<Order>) writeCommand(from, to).getResut();
    }

    @Override
    public List<Request> getRequestSortedByBookName() {
        return (List<Request>) writeCommand().getResut();
    }

    @Override
    public List<Request> getRequestSortedOfQuantity() {
        return (List<Request>) writeCommand().getResut();
    }

    @Override
    public String getBookDescription(String bookName) throws ObjectAvailabilityException {
        return (String) writeCommand(bookName).getResut();
    }

    @Override
    public String getOrderDetails(Integer ip) throws ObjectAvailabilityException {
        return (String) writeCommand(ip).getResut();
    }

    @Override
    public void setBookQuantity(String bookName, int quantity) throws ObjectAvailabilityException {
        writeCommand(bookName, quantity).getResut();
    }

    @Override
    public float getIncome(Date from, Date to) {
        return (float) writeCommand(from, to).getResut();
    }

    @Override
    public void addOrder(Order order) {
        writeCommand(order).getResut();
    }

    @Override
    public void assembleOrder(Order order) {
        writeCommand(order).getResut();
    }


    @Override
    public void cancelTheOrder(Order order) {
        writeCommand(order).getResut();
    }

    @Override
    public void addRequest(Book book) {
        writeCommand(book).getResut();
    }

    @Override
    public List<Request> findRequestByBookName(String name) {
        return (List<Request>) writeCommand(name).getResut();
    }

    @Override
    public void readFromFileAllStore(String filePath) {
        writeCommand(filePath).getResut();
    }

    @Override
    public void writeToFile(String filePath) {
        writeCommand(filePath).getResut();
    }

    @Override
    public Book GetBookByName(String name) throws ObjectAvailabilityException {
        return (Book) writeCommand(name).getResut();
    }

    @Override
    public Order getOrderById(Integer ip) throws ObjectAvailabilityException {
        return (Order) writeCommand(ip).getResut();
    }

    @Override
    public void writeSerializable() {
            writeCommand();
    }

    @Override
    public void readSerializable() {
        writeCommand();
    }

    @Override
    public void exportAllStores() {
        writeCommand();
    }

    @Override
    public void exportBookStore() {
        writeCommand();
    }

    @Override
    public void exportOrderStore() {
        writeCommand();
    }

    @Override
    public void exportRequestStore() {
        writeCommand();
    }

    @Override
    public void importAllStores() {
        writeCommand();
    }

    @Override
    public void importBookStore() {
        writeCommand();
    }

    @Override
    public void importOrderStore() {
        writeCommand();
    }

    @Override
    public void importRequestStore() {
        writeCommand();
    }

    private Response writeCommand(Object ... params){
        return client.writeCommand( new com.senla.server.Command(Thread.currentThread().getStackTrace()[2].getMethodName(), params));
    }
}
