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
    private String description;
    private Date dateIssue;
    private Date datePublication;
    private Float price;
    private int inStock;
    private final String FORMAT_TO_STRING = "Name: %s, Date of Publication: %s, Data Of Issue: %s, Price: %f, In Stock: %d";

    public Book() {
    }

    public Book(String name, Date dateOfIssue, Date datePublication, Float price, int inStock) {
        this.name = name;
        this.dateIssue = dateOfIssue;
        this.datePublication = datePublication;
        this.price = price;
        this.inStock = inStock;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String toString(){
        return String.format(FORMAT_TO_STRING, name, datePublication.toString(),  dateIssue.toString(), price, inStock );
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
