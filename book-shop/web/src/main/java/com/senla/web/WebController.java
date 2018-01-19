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

    Order getCloneOrderById(int id) throws ObjectAvailabilityException;

    List<Order> getCompletedOrder(Date from, Date to);

    List<Order> getCompletedOrderSortedByPrice(Date from, Date to);

    List<Order> getCompletedOrderSortedByCompletedData(Date from, Date to);
}
