package com.senla.web;

import com.google.gson.Gson;
import com.senla.api.IController;
import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Order;
import com.senla.dependencyinjection.DiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;


public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);;
    private static final Gson GSON = new Gson();
    private static  volatile  WebController instance;
    private static IController bakControler;

    public static WebController getInstance() {
        WebController localInstance = instance;
        if (localInstance == null) {
            synchronized (WebController.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new WebController();

                }
            }
        }
        return localInstance;
    }

    public WebController(){
        bakControler = (IController)DiController.getImplementation(IController.class);
    }

    public String getBooksSortedByName() {
        return GSON.toJson(bakControler.getBooksSortedByName());
    }

    public String getBooksSortedByDateIssue() {
        return GSON.toJson(bakControler.getBooksSortedByDateIssue());
    }

    public String getBooksSortedByStockAvailability() {
            return GSON.toJson(bakControler.getBooksSortedByStockAvailability());
    }

    public String getBooksSortedByPrice() {
        return GSON.toJson(bakControler.getBooksSortedByPrice());
    }

    public String getStaleBooksDate() {
        return GSON.toJson(bakControler.getStaleBooksDate());
    }

    public String getStaleBooksPrice(Date date) {
        return GSON.toJson(bakControler.getStaleBooksPrice(date));
    }

    public String getOrderSortedByPrice(){
        return GSON.toJson(bakControler.getOrderSortedByPrice());
    }

    public String getOrderSortedByStatus(){
        return GSON.toJson(bakControler.getOrderSortedByStatus());
    }

    public String getOrderSortedByDataCompletion(){
        return GSON.toJson(bakControler.getOrderSortedByDataCompletion());
    }

    public String getOrderSortedById(){
        return GSON.toJson(bakControler.getOrderSortedById());
    }

    public String getCloneOrderById(int id){
        try {
            return GSON.toJson(bakControler.getCloneOrderById(id));
        } catch (ObjectAvailabilityException e) {
            return GSON.toJson(e);
        }
    }

    public String getCompletedOrder(Date from, Date to){
        return GSON.toJson(bakControler.getCompletedOrder(from, to));
    }

    public String getCompletedOrderSortedByPrice(Date from, Date to){
        return GSON.toJson(bakControler.getCompletedOrderSortedByPrice(from, to));
    }

    public String getCompletedOrderSortedByCompletedData(Date from, Date to){
        return GSON.toJson(bakControler.getCompletedOrderSortedByCompletedData(from, to));
    }

    public String getRequestSortedByBookName(){
        return GSON.toJson(bakControler.getRequestSortedByBookName());
    }

    public String getRequestSortedOfQuantity(){
        return GSON.toJson(bakControler.getRequestSortedOfQuantity());
    }

    public String getBookDescription(String bookName) {
        try {
            return GSON.toJson(bakControler.getBookDescription(bookName));
        } catch (ObjectAvailabilityException e) {
            return GSON.toJson(e);
        }
    }

    public String getOrderDetails(Integer ip) {
        try {
            return GSON.toJson(bakControler.getOrderDetails(ip));
        } catch (ObjectAvailabilityException e) {
            return GSON.toJson(e);
        }
    }

    public String setBookQuantity(String bookName, int quantity){
        try {
            bakControler.setBookQuantity(bookName, quantity);
            return GSON.toJson(true);
        } catch (ObjectAvailabilityException e) {
            return GSON.toJson(e);
        }
    }

    public String getIncome(Date from, Date to){
        return GSON.toJson(bakControler.getIncome(from, to));
    }

    public void addOrder(String orderJson){

        bakControler.addOrder(GSON.fromJson(orderJson, Order.class));
    }

    void assembleOrder(Integer idOrder){
        bakControler.assembleOrder(idOrder);
    }

    void cancelTheOrder(Integer idOrder){
        bakControler.cancelTheOrder(idOrder);
    }

    void addRequest(Integer idBook){
        bakControler.addRequest(idBook);
    }

    public String findRequestByBookName(String name){
        return GSON.toJson(bakControler.findRequestByBookName(name));
    }

    public String getBookByName(String name){
        return GSON.toJson(bakControler.GetBookByName(name));
    }

    public String getOrderById(Integer ip) throws ObjectAvailabilityException {
            return GSON.toJson(bakControler.getOrderById(ip));
    }
}
