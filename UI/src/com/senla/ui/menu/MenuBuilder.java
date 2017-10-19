package com.senla.ui.menu;

import com.senla.ui.action.*;

public class MenuBuilder {

    private static final String CONTENT_HOME_MENU = "|\t     SENLA\n|\tcourses on java\n|\t  Book shop";
    private static final String SHOW_BOOKS_SORTED_BY_NAME = "Show Books Sorted By Name";
    private static final String SHOW_BOOKS_SORTED_BY_STOCK_AVAILABILITY = "Show Books Sorted By Stock Availability";
    private static final String SHOW_BOOKS_SORTED_BY_DATE_ISSUE = "Show Books Sorted By Date Issue";
    private static final String SHOW_BOOKS_SORTED_BY_P_RICE = "Show Books Sorted ByP rice";
    private static final String SHOW_STALE_BOOKS_DATE = "Show Stale Books Date";
    private static final String SHOW_ORDER_SORTED_BY_PRICE = "Show Order Sorted ByPrice";
    private static final String SHOW_ORDER_SORTED_BY_DATA_COMPLETION = "Show Order Sorted ByData Completion";
    private static final String SHOW_COMPLETED_ORDER = "Show Completed Order";
    private static final String SHOW_COMPLETED_ORDER_SORTED_BY_PRICE = "Show Completed Order Sorted ByPrice";
    private static final String SHOW_COMPLETED_ORDER_SORTED_BY_COMPLETED_DATA = "Show Completed OrderSorted By Completed Data";
    private static final String SHOW_ORDER_DETAILS = "Show Order Details";
    private static final String ADD_ORDER = "Add Order";
    private static final String ASSEMBLE_ORDER = "Assemble Order";
    private static final String CANCEL_THE_ORDER = "CancelThe Order";
    private static final String SHOW_STALE_BOOKS_PRICE = "Show Stale Books Price";
    private static final String SHOW_BOOK_DESCRIPTION = "Show Book Description";
    private static final String SHOW_BOOK_AS_QUANTITY = "Show Book As Quantity";
    private static final String SHOW_REQUEST_SORTED_BY_BOOK_NAME = "Show Request Sorted By Book Name";
    private static final String SHOW_REQUEST_SORTED_OF_QUANTITY = "Show Request Sorted Of Quantity";
    private static final String ADD_REQUEST = "Add Request";
    private static final String INCOME_FOR_A_PERIOD_OF_TIME = "Income for a period of time";

    private Menu rootMenu = new Menu();

    public Menu buildMenu(){
        Menu homeMenu = new Menu("Home");
        homeMenu.setContent(
                CONTENT_HOME_MENU);

        Menu orderMenu = new Menu("Order");
        Menu bookMenu = new Menu("Book");
        Menu requestMenu = new Menu("Request");
        Menu shopMenu = new Menu("Shop");

        rootMenu.addNextMenu(homeMenu);

        homeMenu.addNextMenu(orderMenu);
        homeMenu.addNextMenu(bookMenu);
        homeMenu.addNextMenu(requestMenu);
        homeMenu.addNextMenu(shopMenu);

        orderMenu.addItem(new MenuItem(homeMenu));
        orderMenu.addItem(new MenuItem(orderMenu, SHOW_ORDER_SORTED_BY_PRICE, new GetOrderSortedByPrice()));
        orderMenu.addItem(new MenuItem(orderMenu, SHOW_ORDER_SORTED_BY_DATA_COMPLETION, new GetOrderSortedByDataCompletion()));
        orderMenu.addItem(new MenuItem(orderMenu, SHOW_COMPLETED_ORDER, new GetCompletedOrder()));
        orderMenu.addItem(new MenuItem(orderMenu, SHOW_COMPLETED_ORDER_SORTED_BY_PRICE, new GetCompletedOrderSortedByPrice()));
        orderMenu.addItem(new MenuItem(orderMenu, SHOW_COMPLETED_ORDER_SORTED_BY_COMPLETED_DATA, new GetCompletedOrderSortedByCompletedData()));
        orderMenu.addItem(new MenuItem(orderMenu, SHOW_ORDER_DETAILS, new GetOrderDetails()));
        orderMenu.addItem(new MenuItem(orderMenu, ADD_ORDER, new AddOrder()));
        orderMenu.addItem(new MenuItem(orderMenu, ASSEMBLE_ORDER, new AssembleOrder()));
        orderMenu.addItem(new MenuItem(orderMenu, CANCEL_THE_ORDER, new CancelTheOrder()));

        bookMenu.addItem(new MenuItem(homeMenu));
        bookMenu.addItem(new MenuItem(bookMenu, SHOW_BOOKS_SORTED_BY_NAME, new GetBooksSortedByName()));
        bookMenu.addItem(new MenuItem(bookMenu, SHOW_BOOKS_SORTED_BY_STOCK_AVAILABILITY, new GetBooksSortedByStockAvailability()));
        bookMenu.addItem(new MenuItem(bookMenu, SHOW_BOOKS_SORTED_BY_DATE_ISSUE, new GetBooksSortedByDateIssue()));
        bookMenu.addItem(new MenuItem(bookMenu, SHOW_BOOKS_SORTED_BY_P_RICE, new GetBooksSortedByPrice()));
        bookMenu.addItem(new MenuItem(bookMenu, SHOW_STALE_BOOKS_DATE, new GetStaleBooksDate()));
        bookMenu.addItem(new MenuItem(bookMenu, SHOW_STALE_BOOKS_PRICE, new GetStaleBooksPrice()));
        bookMenu.addItem(new MenuItem(bookMenu, SHOW_BOOK_DESCRIPTION, new GetBookDescription()));
        bookMenu.addItem(new MenuItem(bookMenu, SHOW_BOOK_AS_QUANTITY, new SetBookQuantity()));

        requestMenu.addItem(new MenuItem((homeMenu)));
        requestMenu.addItem(new MenuItem(requestMenu, SHOW_REQUEST_SORTED_BY_BOOK_NAME, new GetRequestSortedByBookName()));
        requestMenu.addItem(new MenuItem(requestMenu, SHOW_REQUEST_SORTED_OF_QUANTITY, new GetRequestSortedOfQuantity()));
        requestMenu.addItem(new MenuItem(requestMenu, ADD_REQUEST, new AddRequest()));

        shopMenu.addItem(new MenuItem(homeMenu));
        shopMenu.addItem(new MenuItem(shopMenu, INCOME_FOR_A_PERIOD_OF_TIME, new GetIncome()));

        return rootMenu;
    }


}
