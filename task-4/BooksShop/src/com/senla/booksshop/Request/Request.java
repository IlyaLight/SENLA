package com.senla.booksshop.Request;

/**
 * Created by Light on 22.09.2017.
 */
public class Request {
    private String bookName;
    private boolean completed;

    public Request(String bookName, boolean completed) {
        this.bookName = bookName;
        this.completed = completed;
    }

    public String toString(){
        return new StringBuilder(
                "Book Name: " + bookName
                        + ", Accomplished: " + completed
        ).toString();
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
