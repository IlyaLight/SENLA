package com.senla.booksshop.controller;


import com.senla.api.IController;
import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Book;
import com.senla.api.model.Order;
import com.senla.api.model.Request;
import com.senla.booksshop.service.IBookService;
import com.senla.booksshop.service.IOrderService;
import com.senla.booksshop.service.IRequestService;
import com.senla.booksshop.utility.*;
import dependencyinjection.annotation.ContainsConfigProperty;
import dependencyinjection.annotation.Injection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Controller implements IController {

    @Injection
    private IBookService bookService;
    @Injection
    private IOrderService orderService;
    @Injection
    private IRequestService requestService;
    @ContainsConfigProperty
    private PropertiesHolder propertiesHolder;

    private static final Logger LOGGER          = LoggerFactory.getLogger(Controller.class);

    @Override
    public List<Book> getBooksSortedByName() {
        synchronized (bookService) {
            return bookService.getBooksSortedByName();
        }
        }

    @Override
    public List<Book> getBooksSortedByDateIssue() {
        synchronized (bookService) {
            return bookService.getBooksSortedByDateIssue();
        }
    }

    @Override
    public List<Book> getBooksSortedByStockAvailability() {
        synchronized (bookService) {
            return bookService.getBooksSortedByStockAvailability();
        }
    }

    @Override
    public List<Book> getBooksSortedByPrice() {
        synchronized (bookService) {
            return bookService.getBooksSortedByPrice();
        }
    }

    @Override
    public List<Book> getStaleBooksDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, propertiesHolder.getStaleTime());
        synchronized (bookService) {
            return bookService.getStaleBooksDate(calendar.getTime());
        }
    }

    @Override
    public List<Book> getStaleBooksPrice(Date date) {
        synchronized (bookService) {
            return bookService.getStaleBooksPrice(date);
        }
    }

    @Override
    public List<Order> getOrderSortedByPrice() {
        synchronized (orderService) {
            return orderService.getOrderSortedByPrice();
        }
    }

    @Override
    public List<Order> getOrderSortedByStatus() {
        synchronized (orderService) {
            return orderService.getOrderSortedByStatus();
        }
    }

    @Override
    public List<Order> getOrderSortedByDataCompletion() {
        synchronized (orderService) {
            return orderService.getOrderSortedByDataCompletion();
        }
    }

    @Override
    public List<Order> getOrderSortedById() {
        synchronized (orderService) {
            return orderService.getOrderSortedById();
        }
    }

    @Override
    public Order getCloneOrderById(int id) throws ObjectAvailabilityException{
        Order order;
        synchronized (orderService) {
             order = orderService.getOrderById(id);
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
        synchronized (orderService) {
            return orderService.getCompletedOrder(from, to);
        }
    }

    @Override
    public List<Order> getCompletedOrderSortedByPrice(Date from, Date to) {
        synchronized (orderService) {
            return orderService.getCompletedOrderSortedByPrice(from, to);
        }
    }

    @Override
    public List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to) {
        synchronized (orderService) {
            return orderService.getCompletedOrderSortedByCompletedData(from, to);
        }
    }

    @Override
    public List<Request> getRequestSortedByBookName() {
        List<Request> requests = new ArrayList<>();
       /* List<Book> books = new ArrayList<>();
        synchronized (requestService) {
            try {
                JdbcMySqlUtil.getConnection().setAutoCommit(false);
                requests = requestService.getAll();
                books = bookService.getBooksSortedByName();
                JdbcMySqlUtil.getConnection().commit();
                JdbcMySqlUtil.getConnection().setAutoCommit(true);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
            List<Request> sortedRequests = new ArrayList<>();
            for (Book book : books) {
                for (Request request : requests) {
                    if (book.getId().equals(request.getBookId())){
                        sortedRequests.add(request);
                    }
                }
            }

        }*/
        return requests;
    }

    @Override
    public List<Request> getRequestSortedOfQuantity() {
        synchronized (requestService) {
            return requestService.getRequestSortedOfQuantity();
        }
    }

    @Override
    public List<String> getBookDescription(String bookName) throws ObjectAvailabilityException {
        synchronized (bookService) {
            List<Book> books = bookService.getBookByName(bookName);
            List<String> descriptions = new ArrayList<>();
            for (Book book : books) {
                descriptions.add(book.getDescription());
            }
            return descriptions;
        }

    }

    @Override
    public String getOrderDetails(Integer id) throws ObjectAvailabilityException {
        String s;
        synchronized (orderService) {
            s = orderService.getOrderDetails(id);
        }
        if (s == null) {
            throw new ObjectAvailabilityException();
        } else return s;

    }

    @Override
    public void setBookQuantity(String bookName, int quantity) throws ObjectAvailabilityException {
      /*  Book book = GetBookByName(bookName);
        synchronized (bookService) {
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
        }*/
    }

    @Override
    public float getIncome(Date from, Date to) {
        List<Order> orders;
        synchronized (orderService) {
            orders = new ArrayList<>(orderService.getCompletedOrderSortedByCompletedData(from, to));
        }
        float income = 0;
        for (Order order : orders) {
            income += order.getPrice();
        }
        return income;
    }

    @Override
    public void addOrder(Order order) {
        synchronized (orderService) {
            orderService.create(order);
        }
    }

    @Override
    public void assembleOrder(Integer orderId) {
//        boolean i = true;
//        for (Book book : order.getBooks()) {
//            if (book.getInStock() == 0){
//                i = false;
//            }
//        }
//        if (i){
//            order.setStatus(Order.Status.ASSEMBLED);
//        }
        //synchronized (orderService) {
          //  order.setStatus(Order.Status.ASSEMBLED);
        //}
    }

    @Override
    public void cancelTheOrder(Integer orderId) {
//        synchronized (orderService) {
//            order.setStatus(Order.Status.CANCELED);
//        }
    }

    @Override
    public void addRequest(Integer bookId) throws ObjectAvailabilityException {
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        try {
            Request request = requestService.getRequestByBookId(bookId);
            request.setQuantity(request.getQuantity()+1);
        }catch (ObjectAvailabilityException e){
            Request request = new Request(bookService.getBookById(bookId));
            requestService.create(request);
        }
        em.getTransaction().commit();
        em.close();
          /*  boolean newRequest = true;
        synchronized (requestService) {
            for (Request request : requestStore.getRequestList()) {
                if (request.getBookName().equals(book.getName())) {
                    request.setQuantity(request.getQuantity() + 1);
                    newRequest = false;
                }
            }
            if (newRequest) {
                requestStore.getRequestList().add(new Request(book));
            }
        }*/
    }

    @Override
    public List<Book> GetBookByName(String name) {
        return  bookService.getBookByName(name);
    }

    @Override
    public Order getOrderById(Integer id) throws ObjectAvailabilityException {
//        List<Order> orders = orderService.getOrderList();
//        synchronized (orderService) {
//            for (Order order : orders) {
//                if (order.getId() == id) {
//                    return order;
//                }
//            }
//        }
//        throw new ObjectAvailabilityException();
        return null;
    }

    @Override
    public List<Request> findRequestByBookName(String name) {
        List<Request> requests = new ArrayList<>();
       /* synchronized (requestStore) {
            for (Request request : requestStore.getRequestList()) {
                if (request.getBookName().equals(name)) {
                    requests.add(request);
                }
            }
        }
        if (requests.size() == 0) {
            return null;
        }*/
        return requests;
    }


}


