package com.senla.booksshop.stores;

import com.senla.api.model.Book;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class BookStore implements IBookStore {

    private static final long serialVersionUID = -6727105669857102873L;
    private List<Book> bookList = new ArrayList<>();

    public BookStore(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookStore() {
    }

    @Override
    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public void create(){
        System.out.println("Will be later");
    }

    @Override
    public void read(){
        System.out.println("Will be later");
    }

    @Override
    public void update(){
        System.out.println("Will be later");
    }

    @Override
    public void delete(){
        System.out.println("Will be later");
    }

}
