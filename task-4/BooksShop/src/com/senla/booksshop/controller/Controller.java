package com.senla.booksshop.controller;

import com.senla.booksshop.model.*;
import com.senla.booksshop.model.Request;
import com.senla.booksshop.servis.BookServis;
import com.senla.booksshop.servis.OrderServis;
import com.senla.booksshop.servis.RequestServis;
import com.senla.booksshop.stores.BookStore;
import com.senla.booksshop.stores.OrderStore;
import com.senla.booksshop.stores.RequestStore;
import com.senla.booksshop.utility.WorkWithFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Light on 22.09.2017.
 */
public class Controller implements IController {

    private BookStore bookStore;
    private OrderStore orderStore;
    private RequestStore requestStore;

    @Override
    public BookStore getBookStore() {
        return bookStore;
    }

    @Override
    public void setBookStore(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    @Override
    public OrderStore getOrderStore() {
        return orderStore;
    }

    @Override
    public void setOrderStore(OrderStore orderStore) {
        this.orderStore = orderStore;
    }

    @Override
    public RequestStore getRequestStore() {
        return requestStore;
    }

    @Override
    public void setRequestStore(RequestStore requestStore) {
        this.requestStore = requestStore;
    }

    @Override
    public List<Book> getBooksSortedByName(){
        return BookServis.getBooksSortedByName(bookStore.getBookList());
    }

    @Override
    public List<Book> getBooksSortedByDateIssue(){
        return BookServis.getBooksSortedByDateIssue(bookStore.getBookList());
    }

    @Override
    public List<Book> getBooksSortedByStockAvailability(){
        return BookServis.getBooksSortedByStockAvailability(bookStore.getBookList());
    }

    @Override
    public List<Book> getBooksSortedByPrice(){
        return BookServis.getBooksSortedByPrice(bookStore.getBookList());
    }

    @Override
    public List<Book> getStaleBooksDate(Date date){
        return BookServis.getStaleBooksDate(bookStore.getBookList(), date);
    }

    @Override
    public List<Book> getStaleBooksPrice(Date date){
        return BookServis.getStaleBooksPrice(bookStore.getBookList(), date);
    }

    @Override
    public List<Order> getOrderSortedByPrice() {
        return OrderServis.getOrderSortedByPrice(orderStore.getOrderArrayList());
    }

    @Override
    public List<Order> getOrderSortedByStatus() {
        return OrderServis.getOrderSortedByStatus(orderStore.getOrderArrayList());
    }

    @Override
    public List<Order> getOrderSortedByDataComplection() {
        return OrderServis.getOrderSortedByDataComplection(orderStore.getOrderArrayList());
    }

    @Override
    public List<Order> getCompletedOrder(Date from, Date to) {
        return OrderServis.getCompletedOrder(orderStore.getOrderArrayList(), from, to);
    }

    @Override
    public List<Order> getCompletedOrderSortedByPrice(Date from, Date to) {
        return OrderServis.getCompletedOrderSortedByPrice(orderStore.getOrderArrayList(), from, to);
    }

    @Override
    public List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to) {
        return OrderServis.getCompletedOrderSortedByCompletedData(orderStore.getOrderArrayList(), from, to);
    }

    @Override
    public List<Request> getRequstSortedByBookName(){
        return RequestServis.getRequstSortedByBookName(requestStore.getRequestArrayList());
    }

    @Override
    public List<Request> getRequstSortedOfquantity(){
        return RequestServis.getRequstSortedOfquantity(requestStore.getRequestArrayList());
    }

    @Override
    public String getBookDescription(String bookName){
        return BookServis.getBookDescription(bookStore.getBookList(), bookName);

    }

    @Override
    public String getOrderDetails(Integer ip){
        return OrderServis.getOrderDetails(orderStore.getOrderArrayList(), ip);

    }

    @Override
    public void setBookAsQuantity(String bookName, int quantity){
        Book book = findBookByName(bookName);
        book.setInStock(quantity);
        if (quantity>0) {
            List<Request> requestList = findRequestByBookName(bookName);
            for (Request request : requestList) {
                if (request.getBookName().equals(book.getName())) {
                    request.setQuantity(0);
                }
            }
        }
    }

    @Override
    public float getIncome(Date from, Date to){
        List<Order> orders = OrderServis.getCompletedOrderSortedByCompletedData(orderStore.getOrderArrayList(),from, to);
        float income = 0;
        for (Order order : orders) {
            income += order.getPrice();
        }
        return income;
    }

    @Override
    public void addOrder(List<Book> books, Integer id){
        orderStore.getOrderArrayList().add(new Order(books, id));
    }

    @Override
    public void assembledAnOrder(Order order){
//        boolean i = true;
//        for (Book book : order.getBooks()) {
//            if (book.getInStock() == 0){
//                i = false;
//            }
//        }
//        if (i){
//            order.setStatus(Order.Status.ASSEMBLED);
//        }
        order.setStatus(Order.Status.ASSEMBLED);
    }

    @Override
    public void cancelTheOrder(Order order){
        order.setStatus(Order.Status.CANCELED);
    }

    @Override
    public void addRequst(Book book){
        if (book.getInStock() > 0) {
            boolean newRequst = true;
            for (Request request : requestStore.getRequestArrayList()) {
                if (request.getBookName().equals(book.getName())) {
                    request.setQuantity(request.getQuantity() + 1);
                    newRequst = false;
                }
            }
            if (newRequst) {
                requestStore.getRequestArrayList().add(new Request(book));
            }
        }
    }

    @Override
    public void readFromFile(final String filePath){
        bookStore = new BookStore();
        bookStore.setBookList(WorkWithFile.readBooksFromFile(filePath));
        orderStore = new OrderStore();
        orderStore.setOrderArrayList(WorkWithFile.readOrdersFromFile(filePath));
        requestStore = new RequestStore();
        requestStore.setRequestArrayList(WorkWithFile.readRequestFromFile(filePath));
    }

    @Override
    public void writeToFile(final String filePath){
        WorkWithFile.writeBooksToFile(filePath, bookStore.getBookList());
        WorkWithFile.writeOrdersToFile(filePath, orderStore.getOrderArrayList());
        WorkWithFile.writeRequestsToFile(filePath, requestStore.getRequestArrayList());
    }

    @Override
    public Book findBookByName(String name){
        List<Book> books = bookStore.getBookList();
        for (Book book : books) {
            if (book.getName().equals(name)){
                return book;
            }
        }
        return null;
    }

    @Override
    public Order getOrderByIp(Integer ip){
        for (Order order : orderStore.getOrderArrayList()) {
            if (order.getId() == ip){
                return order;
            }
        }
        return null;
    }

    private List<Request> findRequestByBookName(String name){
        List<Request> requests = new ArrayList<>();
        for (Request request : requestStore.getRequestArrayList()) {
            if (request.getBookName().equals(name)){
                requests.add(request);
            }
        }
        if (requests.size() == 0){
            return null;
        }
        return requests;
    }
}

