package com.senla.booksshop.dao.realization;

import com.senla.api.model.Order;
import com.senla.booksshop.dao.api.IOrderDao;
import com.senla.booksshop.utility.JdbcMySqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MySqlOrderDao extends AbstractJDBCDao<Order, Integer> implements IOrderDao{

    public static final String ID               = "id";
    public static final String PRICE            = "price";
    public static final String DATA_COMPLETION  = "data_completion";
    public static final String DETAILS          = "details";
    public static final String STATUS           = "status";
    public static final String COMPLETED        = "completed";
    public static final String TABLE            = "orders";

    private static final String SELECT_QUERY    = "SELECT id, book_id, quantity FROM " + TABLE + " ";
    private static final String CREATE_QUERY    = "INSERT INTO " + TABLE + " (book_id, quantity) VALUES (?,?);";
    private static final String UPDATE_QUERY    = "UPDATE " + TABLE + " SET book_id = ?, quantity = ?;";
    private static final String DELETE_QUERY    = "DELETE FROM " + TABLE + " WHERE id = ?;";
    private static final String COMPLETED_ORDER = SELECT_QUERY + "WHERE date_issue > ? AND date_issue < ? AND completed = TRUE ORDER BY ? ASC ;";

    private static final String ERROR           = "SQL Error:";
    private static final Logger LOGGER          = LoggerFactory.getLogger(MySqlBookDao.class);

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
    protected List<Order> parseResultSet(ResultSet rs) {
        LinkedList<Order> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(ID));
                order.setPrice(rs.getFloat(PRICE));
                order.setDataCompletion(rs.getDate(DATA_COMPLETION));
                order.setDetails(rs.getString(DETAILS));
                order.setStatus(Order.Status.valueOf(rs.getString(STATUS)));
                order.setCompleted(rs.getBoolean(COMPLETED));
                result.add(order);
            }
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Order order) {
        try {
            statement.setFloat(1, order.getPrice());
            statement.setDate(2, new  java.sql.Date(order.getDataCompletion().getTime()));
            statement.setString(3, order.getDetails());
            statement.setString(4, order.getStatus().name());
            statement.setBoolean(5, order.isCompleted());
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Order object) {
        prepareStatementForInsert(statement, object);
        try {
            statement.setInt(6, object.getId());
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
    }

    @Override
    public List<Order> getCompletedOrder(Date from, Date to, String sortingColumn) {
        List<Order> list = new ArrayList<>();
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(COMPLETED_ORDER)){
            statement.setDate(1, new java.sql.Date(from.getTime()));
            statement.setDate(2, new java.sql.Date(to.getTime()));
            statement.setString(3, sortingColumn);
            ResultSet rs = statement.executeQuery();
            list =  parseResultSet(rs);
        } catch (SQLException e) {
            LOGGER.error(ERROR, e);
        }
        return list;
    }
}
