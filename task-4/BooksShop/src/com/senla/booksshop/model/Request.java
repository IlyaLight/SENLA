package com.senla.booksshop.model;

/**
 * Created by Light on 22.09.2017.
 */
public class Request {
    private Book book;
    private String bookName;
    private Integer quantity;
    private final String FORMAT_TO_STRING = "Book Name: %s, Quantity: %d";

    public Request() {
    }

    public Request(Book book){
        bookName = book.getName();
        quantity = 1;
    }

    public Request(String bookName, Integer quantity) {
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public String toString(){
        return String.format(FORMAT_TO_STRING, bookName, quantity);
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
}
