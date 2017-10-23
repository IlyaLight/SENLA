package com.senla.booksshop.stores;

import com.senla.booksshop.model.Book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class BookStore implements Serializable {

    private List<Book> bookList = new ArrayList<>();

    public BookStore(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookStore() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void create(){
        System.out.println("Will be later");
    }

    public void read(){
        System.out.println("Will be later");
    }

    public void update(){
        System.out.println("Will be later");
    }

    public void delete(){
        System.out.println("Will be later");
    }

}
