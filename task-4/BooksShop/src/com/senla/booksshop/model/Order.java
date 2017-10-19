package com.senla.booksshop.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Light on 22.09.2017.
 */
public class Order implements Cloneable, Serializable {

    private static final String FORMAT_TO_STRING = "id: %d, Data of Completion: %s, Price: %f, Details: %s, Status: %s";
    private static final int COMPLETION_TIME = 30;
    public  enum Status {PROCESSED, ASSEMBLED, COMPLETED, CANCELED}

    private Integer id;
    private List<Book> books;
    private Float price;
    private Date dataCompletion;
    private String details;
    private Status status;
    private boolean completed;



    public Order() {
    }

    @Override
    public Order clone() throws CloneNotSupportedException {
        Order clone = (Order)super.clone();
        clone.books = books;
        return clone;
    }

    public Order(List<Book> books, Integer id){
        this.books = books;
        this.id = id;
        updatePrice();
        status = Status.PROCESSED;
        Calendar from =Calendar.getInstance();
        from.add(COMPLETION_TIME, 0);
        dataCompletion = from.getTime();

    }

    public Order(Integer id, float price, Date dataCompletion, String details, Status status, boolean completed) {
        this.id = id;
        this.price = price;
        this.dataCompletion = dataCompletion;
        this.details = details;

        this.status = status;
        this.completed = completed;
    }

    public String toString(){
        return String.format(FORMAT_TO_STRING, id, dataCompletion.toString(), price, details, status.name());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDataCompletion() {
        return dataCompletion;
    }

    public void setDataCompletion(Date dataCompletion) {
        this.dataCompletion = dataCompletion;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private void updatePrice(){
        price = (float)0.0;
        for (Book book : books) {
            price += book.getPrice();
        }
    }
}
