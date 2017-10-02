package com.senla.booksshop.model;

/**
 * Created by Light on 22.09.2017.
 */
public class Request {
    private Book book;
    private String bookName;
    private boolean completed;
    private int quantity;
    private final String FORMAT_TO_STRING = "Book Name: %s, Completed: %b";

    public Request() {
    }

    public Request(String bookName, boolean completed) {
        this.bookName = bookName;
        this.completed = completed;
    }

    public String toString(){
        return String.format(FORMAT_TO_STRING, bookName,  completed );
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
