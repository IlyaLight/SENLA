package com.senla.booksshop.dao;

import com.senla.api.model.IModel;

public class OrderBookList implements IModel {

    private Integer id;
    private Integer ordersId;
    private Integer bookId;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
