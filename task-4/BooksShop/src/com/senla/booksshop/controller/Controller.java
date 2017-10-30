package com.senla.booksshop.controller;

import com.senla.booksshop.exception.ObjectAvailabilityException;
import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.IModel;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.model.Request;
import com.senla.booksshop.service.BookService;
import com.senla.booksshop.service.OrderService;
import com.senla.booksshop.service.RequestService;
import com.senla.booksshop.stores.BookStore;
import com.senla.booksshop.stores.OrderStore;
import com.senla.booksshop.stores.RequestStore;
import com.senla.booksshop.utility.CsvUtil;
import com.senla.booksshop.utility.SerializableUtil;
import com.senla.booksshop.utility.WorkWithFile;
import com.senla.properties.PropertiesHolder;
import com.senla.properties.PropertiesUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Controller implements IController {

    private BookStore bookStore = new BookStore();
    private OrderStore orderStore = new OrderStore();
    private RequestStore requestStore = new RequestStore();
    private PropertiesHolder propertiesHolder = new PropertiesHolder();

    @Override
    public PropertiesHolder getPropertiesHolder() {
        return propertiesHolder;
    }

    @Override
    public void setPropertiesHolder(PropertiesHolder propertiesHolder) {
        this.propertiesHolder = propertiesHolder;
    }

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
    public List<Book> getBooksSortedByName() {
        return BookService.getBooksSortedByName(bookStore.getBookList());
    }

    @Override
    public List<Book> getBooksSortedByDateIssue() {
        return BookService.getBooksSortedByDateIssue(bookStore.getBookList());
    }

    @Override
    public List<Book> getBooksSortedByStockAvailability() {
        return BookService.getBooksSortedByStockAvailability(bookStore.getBookList());
    }

    @Override
    public List<Book> getBooksSortedByPrice() {
        return BookService.getBooksSortedByPrice(bookStore.getBookList());
    }

    @Override
    public List<Book> getStaleBooksDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, propertiesHolder.getStaleTime());
        return BookService.getStaleBooksDate(bookStore.getBookList(), calendar.getTime());
    }

    @Override
    public List<Book> getStaleBooksPrice(Date date) {
        return BookService.getStaleBooksPrice(bookStore.getBookList(), date);
    }

    @Override
    public List<Order> getOrderSortedByPrice() {
        return OrderService.getOrderSortedByPrice(orderStore.getOrderList());
    }

    @Override
    public List<Order> getOrderSortedByStatus() {
        return OrderService.getOrderSortedByStatus(orderStore.getOrderList());
    }

    @Override
    public List<Order> getOrderSortedByDataCompletion() {
        return OrderService.getOrderSortedByDataCompletion(orderStore.getOrderList());
    }

    @Override
    public List<Order> getOrderSortedById() {
        return OrderService.getOrderSortedById(orderStore.getOrderList());
    }

    @Override
    public Order getCloneOrderById(int id) throws ObjectAvailabilityException{
        Order order = OrderService.getOrderById(orderStore.getOrderList(), id);
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
        return OrderService.getCompletedOrder(orderStore.getOrderList(), from, to);
    }

    @Override
    public List<Order> getCompletedOrderSortedByPrice(Date from, Date to) {
        return OrderService.getCompletedOrderSortedByPrice(orderStore.getOrderList(), from, to);
    }

    @Override
    public List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to) {
        return OrderService.getCompletedOrderSortedByCompletedData(orderStore.getOrderList(), from, to);
    }

    @Override
    public List<Request> getRequestSortedByBookName() {
        return RequestService.getRequestSortedByBookName(requestStore.getRequestList());
    }

    @Override
    public List<Request> getRequestSortedOfQuantity() {
        return RequestService.getRequestSortedOfquantity(requestStore.getRequestList());
    }

    @Override
    public String getBookDescription(String bookName) throws ObjectAvailabilityException {
        Book book = GetBookByName(bookName);
        return book.getDescription();

    }

    @Override
    public String getOrderDetails(Integer id) throws ObjectAvailabilityException {
        String s = OrderService.getOrderDetails(orderStore.getOrderList(), id);
        if (s == null) {
            throw new ObjectAvailabilityException();
        } else return s;

    }

    @Override
    public void setBookQuantity(String bookName, int quantity) throws ObjectAvailabilityException {
        Book book = GetBookByName(bookName);
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

    @Override
    public float getIncome(Date from, Date to) {
        List<Order> orders = OrderService.getCompletedOrderSortedByCompletedData(orderStore.getOrderList(), from, to);
        float income = 0;
        for (Order order : orders) {
            income += order.getPrice();
        }
        return income;
    }

    @Override
    public void addOrder(Order order) {
        orderStore.create(order);
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
        order.setStatus(Order.Status.ASSEMBLED);
    }

    @Override
    public void cancelTheOrder(Order order) {
        order.setStatus(Order.Status.CANCELED);
    }

    @Override
    public void addRequest(Book book) {
            boolean newRequest = true;
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

    @Override
    public Book GetBookByName(String name) throws ObjectAvailabilityException {
        List<Book> books = bookStore.getBookList();
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        throw new ObjectAvailabilityException();
    }

    @Override
    public Order getOrderById(Integer id) throws ObjectAvailabilityException {
        for (Order order : orderStore.getOrderList()) {
            if (order.getId() == id) {
                return order;
            }
        }
        throw new ObjectAvailabilityException();
    }

    @Override
    public List<Request> findRequestByBookName(String name) {
        List<Request> requests = new ArrayList<>();
        for (Request request : requestStore.getRequestList()) {
            if (request.getBookName().equals(name)) {
                requests.add(request);
            }
        }
        if (requests.size() == 0) {
            return null;
        }
        return requests;
    }

    @Override
    public void readFromFileAllStore(final String filePath) {
        bookStore = new BookStore();
        bookStore.setBookList(WorkWithFile.readBooksFromFile(filePath));
        orderStore = new OrderStore();
        orderStore.setOrderList(WorkWithFile.readOrdersFromFile(filePath));
        requestStore = new RequestStore();
        requestStore.setRequestArrayList(WorkWithFile.readRequestFromFile(filePath));
    }

    @Override
    public void writeToFile(final String filePath) {
        WorkWithFile.writeBooksToFile(filePath, bookStore.getBookList());
        WorkWithFile.writeOrdersToFile(filePath, orderStore.getOrderList());
        WorkWithFile.writeRequestsToFile(filePath, requestStore.getRequestList());
    }

    @Override
    public void writeSerializable() {
        String filePath = propertiesHolder.getCsvPath();
        SerializableUtil.writeBook(bookStore, filePath);
        SerializableUtil.writeRequest(requestStore, filePath);
        SerializableUtil.writeOrder(orderStore, filePath);
    }

    @Override
    public void readSerializable() {
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
        CsvUtil.exportBooks(bookStore.getBookList(), filePath);
    }

    @Override
    public void exportOrderStore() {
        String filePath = propertiesHolder.getCsvPath();
        CsvUtil.exportRequests(requestStore.getRequestList(), filePath);
    }

    @Override
    public void exportRequestStore() {
        String filePath = propertiesHolder.getCsvPath();
        CsvUtil.exportOrders(orderStore.getOrderList(), filePath);
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
        updateListById(bookStore.getBookList(), CsvUtil.importBooks(filePath));
    }

    @Override
    public void importOrderStore() {
        String filePath = propertiesHolder.getCsvPath();
        updateListById(orderStore.getOrderList(), CsvUtil.importOrder(filePath));
    }

    @Override
    public void importRequestStore() {
        String filePath = propertiesHolder.getCsvPath();
        updateListById(requestStore.getRequestList(),CsvUtil.importRequest(filePath));
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

    @Override
    public void readPropertiesFromFile(String filePath) {
        propertiesHolder = PropertiesUtil.getPropertiesHolder(filePath);
    }
}


