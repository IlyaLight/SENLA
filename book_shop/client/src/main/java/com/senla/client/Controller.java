package com.senla.client;

import com.senla.api.Command;
import com.senla.api.Response;
import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Book;
import com.senla.api.model.Order;
import com.senla.api.model.Request;
import dependencyinjection.annotation.Injection;

import java.util.Date;
import java.util.List;


public class Controller implements IClientController {

    private static volatile Controller instance;

    public static Controller getInstance() {
        Controller localInstance = instance;
        if (localInstance == null) {
            synchronized (Controller.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Controller();
                    instance.client = Client.getInstance();

                }
            }
        }
        return localInstance;
    }

    @Injection
    private IClient client;

    @Override
    public IClient getClient() {
        return client;
    }

    @Override
    public void setClient(IClient client) {
        this.client = client;
    }

    @Override
    public void stopClient(){
        writeCommand("stopClient");
    }

    @Override
    public List<Book> getBooksSortedByName() {
       return (List<Book>) writeCommand("getBooksSortedByName").getResult();
    }

    @Override
    public List<Book> getBooksSortedByDateIssue() {
        return (List<Book>) writeCommand("getBooksSortedByDateIssue").getResult();
    }

    @Override
    public List<Book> getBooksSortedByStockAvailability() {
        return (List<Book>) writeCommand("getBooksSortedByStockAvailability").getResult();
    }

    @Override
    public List<Book> getBooksSortedByPrice() {
        return (List<Book>) writeCommand("getBooksSortedByPrice").getResult();
    }

    @Override
    public List<Book> getStaleBooksDate() {
        return (List<Book>) writeCommand("getStaleBooksDate").getResult();
    }

    @Override
    public List<Book> getStaleBooksPrice(Date date) {
        return (List<Book>) writeCommand("getStaleBooksPrice", date).getResult();
    }

    @Override
    public List<Order> getOrderSortedByPrice() {
        return (List<Order>) writeCommand("getOrderSortedByPrice").getResult();
    }

    @Override
    public List<Order> getOrderSortedByStatus() {
        return (List<Order>) writeCommand("getOrderSortedByStatus").getResult();
    }

    @Override
    public List<Order> getOrderSortedByDataCompletion() {
        return (List<Order>) writeCommand("getOrderSortedByDataCompletion").getResult();
    }

    @Override
    public List<Order> getOrderSortedById() {
        return (List<Order>) writeCommand("getOrderSortedById").getResult();
    }

    @Override
    public Order getCloneOrderById(int id) throws ObjectAvailabilityException {
        Response response = writeCommand("getCloneOrderById", id);
        if (response.isException()){
            throw new ObjectAvailabilityException();
        }
        return (Order) response.getResult();
    }

    @Override
    public List<Order> getCompletedOrder( Date from, Date to) {
        return (List<Order>) writeCommand("getCompletedOrder", from, to).getResult();
    }

    @Override
    public List<Order> getCompletedOrderSortedByPrice(Date from, Date to) {
        return (List<Order>) writeCommand("getCompletedOrderSortedByPrice", from, to).getResult();
    }

    @Override
    public List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to) {
        return (List<Order>) writeCommand("getCompletedOrderSortedByCompletedData", from, to).getResult();
    }

    @Override
    public List<Request> getRequestSortedByBookName() {
        return (List<Request>) writeCommand("getRequestSortedByBookName").getResult();
    }

    @Override
    public List<Request> getRequestSortedOfQuantity() {
        return (List<Request>) writeCommand("getRequestSortedOfQuantity").getResult();
    }

    @Override
    public String getBookDescription(String bookName) throws ObjectAvailabilityException {
        Response response = writeCommand("getBookDescription", bookName);
        if (response.isException()){
            throw new ObjectAvailabilityException();
        }
        return (String) response.getResult();
    }

    @Override
    public String getOrderDetails(Integer ip) throws ObjectAvailabilityException {
        Response response = writeCommand("getOrderDetails", ip);
        if (response.isException()){
            throw new ObjectAvailabilityException();
        }
        return (String) response.getResult();
    }

    @Override
    public void setBookQuantity(String bookName, int quantity) throws ObjectAvailabilityException {
        Response response = writeCommand("setBookQuantity", bookName, quantity);
        if (response.isException()){
            throw new ObjectAvailabilityException();
        }
    }

    @Override
    public float getIncome(Date from, Date to) {
        return (float) writeCommand("getIncome", from, to).getResult();
    }

    @Override
    public void addOrder(Order order) {
        writeCommand("addOrder", order).getResult();
    }

    @Override
    public void assembleOrder(Order order) {
        writeCommand("assembleOrder", order).getResult();
    }


    @Override
    public void cancelTheOrder(Order order) {
        writeCommand("cancelTheOrder", order).getResult();
    }

    @Override
    public void addRequest(Book book) {
        writeCommand("addRequest", book).getResult();
    }

    @Override
    public List<Request> findRequestByBookName(String name) {
        return (List<Request>) writeCommand("findRequestByBookName", name).getResult();
    }


    public void readFromFileAllStore(String filePath) {
        writeCommand("readFromFileAllStore", filePath).getResult();
    }


    public void writeToFile(String filePath) {
        writeCommand("writeToFile", filePath).getResult();
    }

    @Override
    public Book GetBookByName(String name) throws ObjectAvailabilityException {
        Response response = writeCommand("GetBookByName", name);
        if (response.isException()){
            throw new ObjectAvailabilityException();
        }
        return (Book) response.getResult();
    }

    @Override
    public Order getOrderById(Integer ip) throws ObjectAvailabilityException {
        Response response = writeCommand("getOrderById", ip);
        if (response.isException()){
            throw new ObjectAvailabilityException();
        }
        return (Order) response.getResult();
    }

    @Override
    public void writeSerializable() {
            writeCommand("writeSerializable");
    }

    @Override
    public void readSerializable() {
        writeCommand("readSerializable");
    }

    @Override
    public void exportAllStores() {
        writeCommand("exportAllStores");
    }

    @Override
    public void exportBookStore() {
        writeCommand("exportBookStore");
    }

    @Override
    public void exportOrderStore() {
        writeCommand("exportOrderStore");
    }

    @Override
    public void exportRequestStore() {
        writeCommand("exportRequestStore");
    }

    @Override
    public void importAllStores() {
        writeCommand("importAllStores");
    }

    @Override
    public void importBookStore() {
        writeCommand("importBookStore");
    }

    @Override
    public void importOrderStore() {
        writeCommand("importOrderStore");
    }

    @Override
    public void importRequestStore() {
        writeCommand("importRequestStore");
    }

    private Response writeCommand(String methodName,Object ... params){
        return client.writeCommand( new Command(methodName, params));
    }
}
