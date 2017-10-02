package com.senla.booksshop.model;

import java.util.Date;

/**
 * Created by Light on 22.09.2017.
 */
public class Order {
    private String bookName;
    private float price;
    private Date dataCompletion;
    private String status;
    boolean completed;
    private final String FORMAT_TO_STRING = "Book Name: %s, Data of Completion: %d, Price: %d, Status: %s";

    public Order() {
    }

    public Order(String bookName, float price, Date dataCompletion, String status, boolean completed) {
        this.bookName = bookName;
        this.price = price;
        this.dataCompletion = dataCompletion;
        this.status = status;
        this.completed = completed;
    }

    public String toString(){
        return String.format(FORMAT_TO_STRING, bookName,  dataCompletion.toString(), price, status );
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
