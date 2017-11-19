package com.senla.booksshop.controller;


import com.senla.api.IController;
import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Book;
import com.senla.api.model.IModel;
import com.senla.api.model.Order;
import com.senla.api.model.Request;
import com.senla.booksshop.service.BookService;
import com.senla.booksshop.service.OrderService;
import com.senla.booksshop.service.RequestService;
import com.senla.booksshop.stores.*;
import com.senla.booksshop.utility.CsvUtil;
import com.senla.booksshop.utility.PropertiesHolder;
import com.senla.booksshop.utility.SerializableUtil;
import com.senla.booksshop.utility.WorkWithFile;
import com.senla.dependencyinjection.annotation.ContainsConfigProperty;
import com.senla.dependencyinjection.annotation.Injection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Controller implements IController {

    @Injection
    private IBookStore bookStore = new BookStore();
    @Injection
    private IOrderStore orderStore = new OrderStore();
    @Injection
    private IRequestStore requestStore = new RequestStore();
    @ContainsConfigProperty
    private PropertiesHolder propertiesHolder;


    public PropertiesHolder getPropertiesHolder() {
        return propertiesHolder;
    }

    public void setPropertiesHolder(PropertiesHolder propertiesHolder) {
        this.propertiesHolder = propertiesHolder;
    }

    public IBookStore getBookStore() {
        return bookStore;
    }

    public void setBookStore(IBookStore IBookStore) {
        this.bookStore = IBookStore;
    }

    public IOrderStore getOrderStore() {
        return orderStore;
    }

    public void setOrderStore(IOrderStore IOrderStore) {
        this.orderStore = IOrderStore;
    }

    public IRequestStore getRequestStore() {
        return requestStore;
    }

    public void setRequestStore(IRequestStore IRequestStore) {
        this.requestStore = IRequestStore;
    }

    @Override
    public List<Book> getBooksSortedByName() {
        synchronized (bookStore) {
            return BookService.getBooksSortedByName(bookStore.getBookList());
        }
        }

    @Override
    public List<Book> getBooksSortedByDateIssue() {
        synchronized (bookStore) {
            return BookService.getBooksSortedByDateIssue(bookStore.getBookList());
        }
    }

    @Override
    public List<Book> getBooksSortedByStockAvailability() {
        synchronized (bookStore) {
            return BookService.getBooksSortedByStockAvailability(bookStore.getBookList());
        }
    }

    @Override
    public List<Book> getBooksSortedByPrice() {
        synchronized (bookStore) {
            return BookService.getBooksSortedByPrice(bookStore.getBookList());
        }
    }

    @Override
    public List<Book> getStaleBooksDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, propertiesHolder.getStaleTime());
        synchronized (bookStore) {
            return BookService.getStaleBooksDate(bookStore.getBookList(), calendar.getTime());
        }
    }

    @Override
    public List<Book> getStaleBooksPrice(Date date) {
        synchronized (bookStore) {
            return BookService.getStaleBooksPrice(bookStore.getBookList(), date);
        }
    }

    @Override
    public List<Order> getOrderSortedByPrice() {
        synchronized (orderStore) {
            return OrderService.getOrderSortedByPrice(orderStore.getOrderList());
        }
    }

    @Override
    public List<Order> getOrderSortedByStatus() {
        synchronized (orderStore) {
            return OrderService.getOrderSortedByStatus(orderStore.getOrderList());
        }
    }

    @Override
    public List<Order> getOrderSortedByDataCompletion() {
        synchronized (orderStore) {
            return OrderService.getOrderSortedByDataCompletion(orderStore.getOrderList());
        }
    }

    @Override
    public List<Order> getOrderSortedById() {
        synchronized (orderStore) {
            return OrderService.getOrderSortedById(orderStore.getOrderList());
        }
    }

    @Override
    public Order getCloneOrderById(int id) throws ObjectAvailabilityException{
        Order order;
        synchronized (orderStore) {
             order = OrderService.getOrderById(orderStore.getOrderList(), id);
        }
        if (order == null){
            throw new ObjectAvailabilityException();
        }else {
            try {
                return order.clone();
            } catch (CloneNotSupportedException e) {
               throw  new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Order> getCompletedOrder(Date from, Date to) {
        synchronized (orderStore) {
            return OrderService.getCompletedOrder(orderStore.getOrderList(), from, to);
        }
    }

    @Override
    public List<Order> getCompletedOrderSortedByPrice(Date from, Date to) {
        synchronized (orderStore) {
            return OrderService.getCompletedOrderSortedByPrice(orderStore.getOrderList(), from, to);
        }
    }

    @Override
    public List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to) {
        synchronized (orderStore) {
            return OrderService.getCompletedOrderSortedByCompletedData(orderStore.getOrderList(), from, to);
        }
    }

    @Override
    public List<Request> getRequestSortedByBookName() {
        synchronized (requestStore) {
            return RequestService.getRequestSortedByBookName(requestStore.getRequestList());
        }
    }

    @Override
    public List<Request> getRequestSortedOfQuantity() {
        synchronized (requestStore) {
            return RequestService.getRequestSortedOfquantity(requestStore.getRequestList());
        }
    }

    @Override
    public String getBookDescription(String bookName) throws ObjectAvailabilityException {
        synchronized (bookStore) {
            Book book = GetBookByName(bookName);
            return book.getDescription();
        }

    }

    @Override //поправить
    public String getOrderDetails(Integer id) throws ObjectAvailabilityException {
        String s;
        synchronized (orderStore) {
            s = OrderService.getOrderDetails(orderStore.getOrderList(), id);
        }
        if (s == null) {
            throw new ObjectAvailabilityException();
        } else return s;

    }

    @Override
    public void setBookQuantity(String bookName, int quantity) throws ObjectAvailabilityException {
        Book book = GetBookByName(bookName);
        synchronized (bookStore) {
            book.setInStock(quantity);
            if (quantity > 0 | propertiesHolder.isAutomaticallyExecuteRequest()) {
                List<Request> requestList = findRequestByBookName(bookName);
                if (requestList != null) {
                    for (Request request : requestList) {
                        if (request.getBookName().equals(book.getName())) {
                            request.setQuantity(0);
                        }
                    }
                }
            }
        }
    }

    @Override
    public float getIncome(Date from, Date to) {
        List<Order> orders;
        synchronized (orderStore) {
            orders = new ArrayList<>(OrderService.getCompletedOrderSortedByCompletedData(orderStore.getOrderList(), from, to));
        }
        float income = 0;
        for (Order order : orders) {
            income += order.getPrice();
        }
        return income;
    }

    @Override
    public void addOrder(Order order) {
        synchronized (orderStore) {
            orderStore.create(order);
        }
    }

    @Override
    public void assembleOrder(Order order) {
//        boolean i = true;
//        for (Book book : order.getBooks()) {
//            if (book.getInStock() == 0){
//                i = false;
//            }
//        }
//        if (i){
//            order.setStatus(Order.Status.ASSEMBLED);
//        }
        synchronized (orderStore) {
            order.setStatus(Order.Status.ASSEMBLED);
        }
    }

    @Override
    public void cancelTheOrder(Order order) {
        synchronized (orderStore) {
            order.setStatus(Order.Status.CANCELED);
        }
    }

    @Override
    public void addRequest(Book book) {
            boolean newRequest = true;
        synchronized (requestStore) {
            for (Request request : requestStore.getRequestList()) {
                if (request.getBookName().equals(book.getName())) {
                    request.setQuantity(request.getQuantity() + 1);
                    newRequest = false;
                }
            }
            if (newRequest) {
                requestStore.getRequestList().add(new Request(book));
            }
        }
    }

    @Override
    public Book GetBookByName(String name) throws ObjectAvailabilityException {
        List<Book> books = bookStore.getBookList();
        synchronized (bookStore) {
            for (Book book : books) {
                if (book.getName().equals(name)) {
                    return book;
                }
            }
        }
        throw new ObjectAvailabilityException();
    }

    @Override
    public Order getOrderById(Integer id) throws ObjectAvailabilityException {
        List<Order> orders = orderStore.getOrderList();
        synchronized (orderStore) {
            for (Order order : orders) {
                if (order.getId() == id) {
                    return order;
                }
            }
        }
        throw new ObjectAvailabilityException();
    }

    @Override
    public List<Request> findRequestByBookName(String name) {
        List<Request> requests = new ArrayList<>();
        synchronized (requestStore) {
            for (Request request : requestStore.getRequestList()) {
                if (request.getBookName().equals(name)) {
                    requests.add(request);
                }
            }
        }
        if (requests.size() == 0) {
            return null;
        }
        return requests;
    }

    @Override
    synchronized public void  readFromFileAllStore(final String filePath) {
        bookStore = new BookStore();
        bookStore.setBookList(WorkWithFile.readBooksFromFile(filePath));
        orderStore = new OrderStore();
        orderStore.setOrderList(WorkWithFile.readOrdersFromFile(filePath));
        requestStore = new RequestStore();
        requestStore.setRequestArrayList(WorkWithFile.readRequestFromFile(filePath));
    }

    @Override
    synchronized public void writeToFile(final String filePath) {
        WorkWithFile.writeBooksToFile(filePath, bookStore.getBookList());
        WorkWithFile.writeOrdersToFile(filePath, orderStore.getOrderList());
        WorkWithFile.writeRequestsToFile(filePath, requestStore.getRequestList());
    }

    @Override
    synchronized public void writeSerializable() {
        String filePath = propertiesHolder.getCsvPath();
        SerializableUtil.writeBook(bookStore, filePath);
        SerializableUtil.writeRequest(requestStore, filePath);
        SerializableUtil.writeOrder(orderStore, filePath);
    }

    @Override
    synchronized public void readSerializable() {
        String filePath = propertiesHolder.getCsvPath();
        bookStore = SerializableUtil.readBooks(filePath);
        orderStore = SerializableUtil.readOrder(filePath);
        requestStore = SerializableUtil.readRequest(filePath);
    }

    @Override
    public void exportAllStores() {
        exportBookStore();
        exportOrderStore();
        exportRequestStore();
    }

    @Override
    public void exportBookStore() {
        String filePath = propertiesHolder.getCsvPath();
        synchronized (bookStore) {
            CsvUtil.exportBooks(bookStore.getBookList(), filePath);
        }
    }

    @Override
    public void exportOrderStore() {
        String filePath = propertiesHolder.getCsvPath();
        synchronized (requestStore) {
            CsvUtil.exportRequests(requestStore.getRequestList(), filePath);
        }
    }

    @Override
    public void exportRequestStore() {
        String filePath = propertiesHolder.getCsvPath();
        synchronized (orderStore) {
            CsvUtil.exportOrders(orderStore.getOrderList(), filePath);
        }
    }

    @Override
    public void importAllStores() {
        importBookStore();
        importOrderStore();
        importRequestStore();
    }

    @Override
    public void importBookStore() {
        String filePath = propertiesHolder.getCsvPath();
        synchronized (bookStore) {
            updateListById(bookStore.getBookList(), CsvUtil.importBooks(filePath));
        }
    }

    @Override
    public void importOrderStore() {
        String filePath = propertiesHolder.getCsvPath();
        synchronized (orderStore) {
            updateListById(orderStore.getOrderList(), CsvUtil.importOrder(filePath));
        }
    }

    @Override
    public void importRequestStore() {
        String filePath = propertiesHolder.getCsvPath();
        synchronized (requestStore) {
            updateListById(requestStore.getRequestList(), CsvUtil.importRequest(filePath));
        }
    }

    private <T extends IModel> void updateListById(List<T> setList, List<T> impList) {
        if (setList.size()>0) {
            for (T o1 : setList) {
                for (T o2 : impList) {
                    if (o1.getId() == o2.getId()) {
                        o1 = o2;
                    } else {
                        setList.add(o2);
                    }
                }

            }
        }else {
            setList.addAll(impList);
        }
    }

}


