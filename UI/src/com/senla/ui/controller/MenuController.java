package com.senla.ui.controller;


import com.senla.booksshop.controller.IController;
import com.senla.booksshop.exception.ObjectAvailabilityException;
import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.utility.WorkWithFile;
import com.senla.ui.utility.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuController implements IMenuController {

    private static final String BOOKS_WITH_THE_SAME_NAME_ARE_NOT_FOUND = "books with the same name are not found";
    private static final String ENTER_BOOK_NAME = "enter book name";
    private static final String ENTER_QUANTITY = "enter quantity";
    private static final String ENTER_ID = "enter id";
    private static final String INCOME_FOR_A_PERIOD_OF_TIME = "Income for a period of time";
    private static final String FROM = "from";
    private static final String TO = "to";
    private static final String EXCEPTION = "Exception: ";
    private static final String ORDER_WITH_THE_SAME_ID_ARE_NOT_FOUND = "order with the same id are not found";
    private static final String ADD_ANOTHER_BOOK = "add another book?";

    private IController shopController;
    private static Logger log = Logger.getLogger(WorkWithFile.class.getName());

    public MenuController(IController shopController) {
        this.shopController = shopController;
    }

    @Override
    public void getIncome(){
        Console.out(INCOME_FOR_A_PERIOD_OF_TIME);
        Console.out(Float.toString(shopController.getIncome(Console.getDate(FROM),Console.getDate(TO))));
    }

    @Override
    public void getBooksSortedByName(){
        Console.outCollection(shopController.getBooksSortedByName());
    }

    @Override
    public void  getBooksSortedByDateIssue() {
    Console.outCollection(shopController.getBooksSortedByDateIssue());
    }

    @Override
    public  void getBooksSortedByStockAvailability(){
        Console.outCollection(shopController.getBooksSortedByStockAvailability());
    }

    @Override
    public void getBooksSortedByPrice(){
        Console.outCollection(shopController.getBooksSortedByPrice());
    }

    @Override
    public void getStaleBooksDate(){
        Console.outCollection(shopController.getStaleBooksDate());
    }

    @Override
    public void getStaleBooksPrice(){
        Console.out(INCOME_FOR_A_PERIOD_OF_TIME);
        Console.outCollection(shopController.getStaleBooksPrice(Console.getDate(FROM)));
    }

    @Override
    public void getOrderSortedByPrice(){
        Console.outCollection(shopController.getOrderSortedByPrice());
    }

    @Override
    public void getOrderSortedByStatus(){
        Console.outCollection(shopController.getOrderSortedByStatus());
    }

    @Override
    public void getOrderSortedByDataCompletion(){
        Console.outCollection(shopController.getOrderSortedByDataCompletion());
    }

    @Override
    public void getCompletedOrder(){
        Console.out(INCOME_FOR_A_PERIOD_OF_TIME);
        Console.outCollection(shopController.getCompletedOrder(Console.getDate(FROM),Console.getDate(TO)));
    }

    @Override
    public void getCompletedOrderSortedByPrice(){
        Console.out(INCOME_FOR_A_PERIOD_OF_TIME);
        Console.outCollection(shopController.getCompletedOrderSortedByPrice(Console.getDate(FROM),Console.getDate(TO)));
    }

    @Override
    public void getCompletedOrderSortedByCompletedData(){
        Console.outCollection(shopController.getCompletedOrderSortedByCompletedData(Console.getDate(FROM),Console.getDate(TO)));
    }

    @Override
    public void getRequestSortedByBookName(){
        Console.outCollection(shopController.getRequestSortedByBookName());
    }

    @Override
    public void getRequestSortedOfQuantity(){
        Console.outCollection(shopController.getRequestSortedOfQuantity());
    }

    @Override
    public void getBookDescription(){
        String bookName = Console.inString(ENTER_BOOK_NAME);
        try {
            Console.out(shopController.getBookDescription(bookName));
        }catch (ObjectAvailabilityException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            Console.out(BOOKS_WITH_THE_SAME_NAME_ARE_NOT_FOUND);
        }
    }

    @Override
    public void getOrderDetails(){
        int id = Console.getInt(ENTER_ID);
        try {
            Console.out(shopController.getOrderDetails(id));
        }catch (ObjectAvailabilityException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            Console.out(ORDER_WITH_THE_SAME_ID_ARE_NOT_FOUND);
        }
    }

    @Override
    public void setBookQuantity(){
        String bookName = Console.inString(ENTER_BOOK_NAME);
        int quantity = Console.getInt(ENTER_QUANTITY);
        try {
        shopController.setBookQuantity(bookName, quantity);
        }catch (ObjectAvailabilityException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            Console.out(BOOKS_WITH_THE_SAME_NAME_ARE_NOT_FOUND);
        }
    }

    @Override
    public void addOrder(){
        List<Book> books = new ArrayList<>();
        boolean repeat = true;
        while (repeat){
            try {
                books.add(shopController.GetBookByName(Console.inString(ENTER_BOOK_NAME)));
            }catch (ObjectAvailabilityException e){
                log.log(Level.SEVERE, EXCEPTION, e);
                Console.out(BOOKS_WITH_THE_SAME_NAME_ARE_NOT_FOUND);
            }
           repeat =Console.confirmation(ADD_ANOTHER_BOOK);
        }
        int id = Console.getInt(ENTER_ID);
        shopController.addOrder(books, id);
    }

    @Override
    public void assembleOrder(){
        try {
            Order order = shopController.getOrderById( Console.getInt(ENTER_ID));
           shopController.assembleOrder(order);
        }catch (ObjectAvailabilityException e){
            log.log(Level.SEVERE, EXCEPTION , e);
            Console.out(ORDER_WITH_THE_SAME_ID_ARE_NOT_FOUND);
        }
    }

    @Override
    public void cancelTheOrder(){
        try {
            Order order = shopController.getOrderById( Console.getInt(ENTER_ID));
            shopController.cancelTheOrder(order);
        }catch (ObjectAvailabilityException e){
            log.log(Level.SEVERE, EXCEPTION , e);
            Console.out(ORDER_WITH_THE_SAME_ID_ARE_NOT_FOUND);
        }
    }

    @Override
    public void addRequest(){
       String bookName = Console.inString(ENTER_BOOK_NAME);
        try {
            Book book = shopController.GetBookByName(bookName);
            shopController.addRequest(book);
        }catch (ObjectAvailabilityException e){
            log.log(Level.SEVERE, EXCEPTION , e);
            Console.out(BOOKS_WITH_THE_SAME_NAME_ARE_NOT_FOUND);
        }


    }

}
