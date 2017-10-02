package com.senla.booksshop.stores;

import com.senla.booksshop.model.Book;


import java.util.ArrayList;


/**
 * Created by Light on 27.09.2017.
 */
public class BookCollection {

    private ArrayList<Book> bookArrayList = new ArrayList<Book>();

    public ArrayList<Book> getBookList() {
        return bookArrayList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookArrayList = bookList;
    }

    public void create(){}

    public void read(){}

    public void update(){}

    public void delete(){}

}
