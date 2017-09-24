package com.senla.booksshop.Order;

import java.util.Date;

/**
 * Created by Light on 22.09.2017.
 */
public class Order {
    private String[] bookName;
    private float price;
    private Date dataCompletion;
    private String status;
    boolean completeness;

    public String toString(){
        return new StringBuilder(
                "Name: " + bookName
                        + ", Data of Completion: " + dataCompletion.toString()
                        + ", Price: " + price
                        + ", Status " + status
        ).toString();
    }

    public String[] getBookName() {
        return bookName;
    }

    public void setBookName(String[] bookName) {
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
        return completeness;
    }

    public void setCompleteness(boolean completeness) {
        this.completeness = completeness;
    }
}
