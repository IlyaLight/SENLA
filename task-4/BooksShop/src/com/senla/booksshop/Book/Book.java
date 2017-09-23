package com.senla.booksshop.Book;

import java.util.Date;

/**
 * Created by Light on 22.09.2017.
 */
public class Book {
    private String name;
    private Date dateOfIssue;
    private float  Price;
    private int stockAvailability;

    public Book() {
    }

    public Book(String name, Date dateOfIssue, float price, int stockAvailability) {
        this.name = name;
        this.dateOfIssue = dateOfIssue;
        Price = price;
        this.stockAvailability = stockAvailability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int isStockAvailability() {
        return stockAvailability;
    }

    public void setStockAvailability(int stockAvailability) {
        this.stockAvailability = stockAvailability;
    }
}
