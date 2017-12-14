package com.senla.booksshop.dao;

import com.senla.api.model.Order;
import com.senla.booksshop.utility.JdbcMySqlUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySqlOrderDao extends AbstractJDBCDao<Order, Integer> {

    private static final String TABLE               = "orders";
    private static final String SELECT_QUERY        = "SELECT id, book_id, quantity FROM " + TABLE + " ";
    private static final String CREATE_QUERY        = "INSERT INTO " + TABLE + " (book_id, quantity) VALUES (?,?);";
    private static final String UPDATE_QUERY        = "UPDATE " + TABLE + " SET book_id = ?, quantity = ?;";
    private static final String DELETE_QUERY        = "DELETE FROM " + TABLE + " WHERE id= ?;";

    private static final String WHERE_ID             = "WHERE id = ?";



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
    protected void prepareStatementForInsert(PreparedStatement statement, Order order) throws PersistException {
        try {
            statement.setFloat(1, order.getPrice());
            statement.setDate(2, new  java.sql.Date(order.getDataCompletion().getTime()));
            statement.setString(3, order.getDetails());
            statement.setString(4, order.getStatus().name());
            statement.setBoolean(5, order.isCompleted());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Order object) throws PersistException {
        prepareStatementForInsert(statement, object);
        try {
            statement.setInt(6, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public Order create() throws PersistException {
        return null;
    }

    @Override
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

    @Override
    public Order getByPK(int key) throws PersistException{
        Order order = super.getByPK(key);
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(OBL_SELECT_QUERY + WHERE_ID)){
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            List<Integer> bookIds = new ArrayList<>();
            while (rs.next()){
                bookIds.add(rs.getInt("book_id"));
            }
            order.setBookIds(bookIds);
            return order;
        } catch (Exception e){
            throw new PersistException(e);
        }
    }
}
