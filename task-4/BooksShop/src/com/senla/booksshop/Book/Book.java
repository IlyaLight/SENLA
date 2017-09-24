package com.senla.booksshop.Book;

import java.util.Date;

/**
 * Created by Light on 22.09.2017.
 */
public class Book {
    private String name;
    private Date dateIssue;
    private float price;
    private boolean stockAvailability;

    public Book() {
    }

    public Book(String name, Date dateOfIssue, float price, boolean stockAvailability) {
        this.name = name;
        this.dateIssue = dateOfIssue;
        this.price = price;
        this.stockAvailability = stockAvailability;
    }

    public String toString(){
        return new StringBuilder(
                "Name: " + name
                + ", Data of Issue: " + dateIssue.toString()
                + ", Price: " + price
                + ", Stock Availability: " + stockAvailability
        ).toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStockAvailability() {
        return stockAvailability;
    }

    public void setStockAvailability(boolean stockAvailability) {
        this.stockAvailability = stockAvailability;
    }
}
