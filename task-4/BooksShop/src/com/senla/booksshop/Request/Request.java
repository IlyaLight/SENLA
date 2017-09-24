package com.senla.booksshop.Request;

/**
 * Created by Light on 22.09.2017.
 */
public class Request {
    private String bookName;
    private boolean accomplished;

    public Request(String bookName, boolean accomplished) {
        this.bookName = bookName;
        this.accomplished = accomplished;
    }

    public String toString(){
        return new StringBuilder(
                "Book Name: " + bookName
                        + ", Accomplished: " + accomplished
        ).toString();
    }

    @Override
    public boolean equals(Object request){
        return this.bookName.equals(((Request)request).bookName);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isAccomplished() {
        return accomplished;
    }

    public void setAccomplished(boolean accomplished) {
        this.accomplished = accomplished;
    }
}
