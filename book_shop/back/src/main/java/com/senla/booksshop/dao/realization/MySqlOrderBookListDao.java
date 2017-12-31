package com.senla.booksshop.dao.realization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlOrderBookListDao extends AbstractJDBCDao<OrderBookList, Integer> {

    public static final String ID               = "id";
    public static final String BOOK_ID          = "book_id";
    public static final String ORDER_ID         = "order_id";
    public static final String TABLE            = "order_book_list";

    private static final String SELECT_QUERY    = "SELECT id, order_id, book_id, quantity FROM " + TABLE + " ";
    private static final String CREATE_QUERY    = "INSERT INTO " + TABLE + " (order_id, book_id) VALUES (?,?);";
    private static final String UPDATE_QUERY    = "UPDATE " + TABLE + " SET book_id = ?, quantity = ?;";
    private static final String DELETE_QUERY    = "DELETE FROM " + TABLE + " WHERE id = ?;";

    private static final String ERROR           = "SQL Error:";
    private static final Logger LOGGER          = LoggerFactory.getLogger(MySqlOrderBookListDao.class);

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
    protected List<OrderBookList> parseResultSet(ResultSet rs) {
        LinkedList<OrderBookList> result = new LinkedList<>();
        try {
            while (rs.next()){
                OrderBookList orderBookList = new OrderBookList();
                orderBookList.setId(rs.getInt(ID));
                orderBookList.setBookId(rs.getInt(BOOK_ID));
                orderBookList.setOrdersId(rs.getInt(ORDER_ID));
                result.add(orderBookList);
            }
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, OrderBookList orderBookList)  {
        try {
            statement.setInt(1, orderBookList.getOrdersId());
            statement.setInt(2, orderBookList.getBookId());
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, OrderBookList object)  {

    }

}
