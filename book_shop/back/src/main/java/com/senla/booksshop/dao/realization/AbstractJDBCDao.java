package com.senla.booksshop.dao.realization;

import com.senla.api.model.IModel;
import com.senla.booksshop.dao.api.IGenericDao;
import com.senla.booksshop.utility.JdbcMySqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractJDBCDao<T extends IModel, PK > implements IGenericDao<T, PK> {

    private static final String WHERE_ID             = "WHERE id = ?";
    private static final String ORDER_BY = "ORDER BY ";
    private static final String CLOSE = ";";

    private static final String ERROR = "SQL Error:";

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJDBCDao.class);

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    protected abstract List<T> parseResultSet(ResultSet rs) throws SQLException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws SQLException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws SQLException;

    @Override
    public void create(T object) {
        String sql = getCreateQuery();
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatementForInsert(statement, object);
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
    }

    @Override
    public T getByPK(int key) {
        String sql = getSelectQuery();
        sql += WHERE_ID;
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql)){
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return parseResultSet(rs).iterator().next();
            }
            return null;
        } catch (Exception e){
            LOGGER.error(ERROR, e);
            return null;
        }

    }

    @Override
    public void update(T object) {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql)) {
            prepareStatementForUpdate(statement, object);
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
    }

    @Override
    public void delete(T object) {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql)) {
                statement.setObject(1, object.getId());
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
    }

    @Override
    public List<T> getAll( String... sortingColumn) {
        List<T> list = new ArrayList<>();
        StringBuilder query = new StringBuilder(getSelectQuery());
        query.append(ORDER_BY);
        for (int i = 0; i < sortingColumn.length - 2; i++) {
            query.append(sortingColumn[i]);
            query.append(", ");
        }
        query.append(sortingColumn[sortingColumn.length-1]);
        try (Statement statement = JdbcMySqlUtil.getConnection().prepareStatement(query.toString())){
            ResultSet rs = statement.executeQuery(query.toString());
            list =  parseResultSet(rs);
        } catch (SQLException e) {
            LOGGER.error(ERROR, e);
        }
        return  list;
    }

}
