package com.senla.ui.controller;


;import com.senla.client.IClientController;

public interface IMenuController {

    IClientController getShopController();

    void setShopController(IClientController shopController);

    void getIncome();

    void getBooksSortedByName();

    void  getBooksSortedByDateIssue();

    void getBooksSortedByStockAvailability();

    void getBooksSortedByPrice();

    void getStaleBooksDate();

    void getStaleBooksPrice();

    void getOrderSortedByPrice();

    void getOrderSortedByStatus();

    void getOrderSortedByDataCompletion();

    void getCompletedOrder();

    void getCompletedOrderSortedByPrice();

    void getCompletedOrderSortedByCompletedData();

    void getRequestSortedByBookName();

    void getRequestSortedOfQuantity();

    void getBookDescription();

    void getOrderDetails();

    void setBookQuantity();

    void addOrder();

    void assembleOrder();

    void cancelTheOrder();

    void addRequest();

    void exportAllStores();

    void exportBookStore();

    void exportOrderStore();

    void exportRequestStore();

    void importAllStores();

    void importBookStore();

    void importOrderStore();

    void importRequestStore();

    void cloneOrder();
}
