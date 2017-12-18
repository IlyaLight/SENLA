package com.senla.booksshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
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
        LinkedList<OrderBookList> result = new LinkedList<>();
        try {
            while (rs.next()){
                OrderBookList orderBookList = new OrderBookList();
                orderBookList.setId(rs.getInt("id"));
                orderBookList.setBookId(rs.getInt("book_id"));
                orderBookList.setOrdersId(rs.getInt("order_id"));
                result.add(orderBookList);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, OrderBookList orderBookList) throws PersistException {
        try {
            statement.setInt(1, orderBookList.getOrdersId());
            statement.setInt(2, orderBookList.getBookId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, OrderBookList object) throws PersistException {

    }

    @Override
    public OrderBookList create() throws PersistException {
        return null;
    }
}
