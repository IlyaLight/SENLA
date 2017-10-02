package com.senla.booksshop.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Light on 22.09.2017.
 */
public class Book {
    private ArrayList<Order> orderArrayList;
    private Request request;
    private String name;
    private Date dateIssue;
    private float price;
    private int inStock;
    private final String FORMAT_TO_STRING = "Name: %s, Data Of Issue: %s, Price: %f, In Stock: %d";

    public Book() {
    }

    public Book(String name, Date dateOfIssue, float price, int inStock) {
        this.name = name;
        this.dateIssue = dateOfIssue;
        this.price = price;
        this.inStock = inStock;
    }

    public String toString(){
        return String.format(FORMAT_TO_STRING, name,  dateIssue.toString(), price, inStock );
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

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
