package com.senla.booksshop;


import com.senla.booksshop.objekt.Request;
import com.senla.booksshop.sorted.SortedRequest;
import com.senla.booksshop.collection.CollectionBook;

import java.util.ArrayList;

import static com.senla.booksshop.Print.printCollection;

public class Main {

    public static void main(String[] args) {
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request("x", true));
        requests.add(new Request("x", true));
        requests.add(new Request("c", true));
        requests.add(new Request("c", true));
        requests.add(new Request("c", true));
        requests.add(new Request("a", false));
        requests.add(new Request("b", true));
        requests.add(new Request("b", true));
        requests.add(new Request("b", true));
        requests.add(new Request("x", true));


        SortedRequest sortedDataBase = new SortedRequest();
        sortedDataBase.setRequestArrayList(requests);
        ArrayList<Request> names = sortedDataBase.getRequstSortedNumberRequst();
        printCollection(names);

        CollectionBook collectionBook = new CollectionBook();
        collectionBook.readFromFile("e:/books.txt");
        collectionBook.writeBookList("e:/books2.txt");
//        ArrayList<Book> books = collectionBook.getBookList();
//        books.add(new Book("test", new Date(1862, 2, 1), (float)151.12, true));
//        books.add(new Book("test1", new Date(1862, 2, 1), (float)151.12, true));
//        books.add(new Book("test2", new Date(1862, 2, 1), (float)151.12, true));
//        collectionBook.writeBookList("e:/books.txt");
    }
}
