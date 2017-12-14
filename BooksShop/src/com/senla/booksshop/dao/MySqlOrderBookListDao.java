package com.senla.booksshop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MySqlOrderBookListDao extends AbstractJDBCDao<OrderBookList, Integer> {

    private static final String TABLE           = "order_book_list";
    private static final String SELECT_QUERY    = "SELECT id, order_id, book_id, quantity FROM " + TABLE + " ";
    private static final String CREATE_QUERY    = "INSERT INTO " + TABLE + " (order_id, book_id) VALUES (?,?);";
    private static final String UPDATE_QUERY    = "UPDATE " + TABLE + " SET book_id = ?, quantity = ?;";
    private static final String DELETE_QUERY    = "DELETE FROM " + TABLE + " WHERE id = ?;";
    @Override
    public String getSelectQuery() {
        return SELECT_QUERY;
    }

    @Override
    public String getCreateQuery() {
        return CREATE_QUERY;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_QUERY;
    }

    @Override
    protected List<OrderBookList> parseResultSet(ResultSet rs) throws PersistException {
        return null;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, OrderBookList object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, OrderBookList object) throws PersistException {

    }

    @Override
    public OrderBookList create() throws PersistException {
        return null;
    }
}
