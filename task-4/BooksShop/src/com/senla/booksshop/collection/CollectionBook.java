package com.senla.booksshop.collection;

import com.danco.training.TextFileWorker;
import com.senla.booksshop.objekt.Book;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Light on 27.09.2017.
 */
public class CollectionBook {

    private ArrayList<Book> bookList;

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void readFromFile(final String filePath){
        TextFileWorker textFileWorker = new TextFileWorker(filePath);
        String[] strings = textFileWorker.readFromFile();
        bookList = new ArrayList<Book>();
        for (String string : strings) {
            String[] book = string.split(" ");
            bookList.add(new Book(book[0],
                    new Date(Long.decode(book[1])),
                    Float.parseFloat(book[2]),
                    Boolean.parseBoolean(book[3])));
        }
    }

    public void writeBookList(final String filePath){
        TextFileWorker textFileWorker = new TextFileWorker(filePath);
        ArrayList<String> books = new ArrayList<String>();
        for (Book book : bookList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(book.getName() + " ");
            stringBuilder.append(book.getDateIssue().getTime() + " ");
            stringBuilder.append(book.getPrice() + " ");
            stringBuilder.append(book.isInStock());
            books.add(stringBuilder.toString());
        }
        textFileWorker.writeToFile(books.toArray(new String[books.size()]));
    }

}
