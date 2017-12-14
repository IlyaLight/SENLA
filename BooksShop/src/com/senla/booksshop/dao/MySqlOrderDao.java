package com.senla.booksshop.dao;

import com.senla.api.model.Order;
import com.senla.booksshop.utility.JdbcMySqlUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySqlOrderDao extends AbstractJDBCDao<Order, Integer> {

    private static final String TABLE               = "orders";
    private static final String SELECT_QUERY        = "SELECT id, book_id, quantity FROM " + TABLE + " ";
    private static final String CREATE_QUERY        = "INSERT INTO " + TABLE + " (book_id, quantity) VALUES (?,?);";
    private static final String UPDATE_QUERY        = "UPDATE " + TABLE + " SET book_id = ?, quantity = ?;";
    private static final String DELETE_QUERY        = "DELETE FROM " + TABLE + " WHERE id= ?;";
    private static final String OBL_TABLE           = "order_book_list";
    private static final String OBL_SELECT_QUERY    = "SELECT order_id, book_id, quantity FROM " + TABLE + " ";
    private static final String OBL_CREATE_QUERY    = "INSERT INTO " + TABLE + " (order_id, book_id) VALUES (?,?);";
    //private static final String OBL_UPDATE_QUERY    = "UPDATE " + TABLE + " SET book_id = ?, quantity = ?;";
    private static final String OBL_DELETE_QUERY    = "DELETE FROM " + TABLE + " WHERE book_id = ?;";


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
    protected List<Order> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Order> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setPrice(rs.getFloat("price"));
                order.setDataCompletion(rs.getDate("data_completion"));
                order.setDetails(rs.getString("details"));
                order.setStatus(Order.Status.valueOf(rs.getString("status")));
                order.setCompleted(rs.getBoolean("completed"));
                result.add(order);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Order object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Order object) throws PersistException {

    }

    @Override
    public Order create() throws PersistException {
        return null;
    }

    public int persist(Order order) throws PersistException {
        int orderId = (super.persist(order));
        List<Integer> bookIds= order.getBookIds();
        for (Integer bookId : bookIds) {
            try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(OBL_CREATE_QUERY)) {
                statement.setInt(1, orderId);
                statement.setInt(2, bookId);
            }catch (SQLException e){
                throw new PersistException(e);
            }
        }
        return orderId;
    }


}
