package com.senla.booksshop.dao;

import com.senla.api.model.IModel;
import com.senla.api.model.Order;
import com.senla.booksshop.utility.JdbcMySqlUtil;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractJDBCDao<T extends IModel, PK  extends Serializable> implements GenericDao<T, PK> {

    private static final String PERSIST_SQL_LAST_ID = "WHERE id = last_insert_id();";
    private static final String WHERE_ID             = "WHERE id = ?";

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException;

    @Override
    public int persist(T object) throws PersistException {
        if (object.getId() != null) {
            throw new PersistException("Object is already persist.");
        }
        String sql = getCreateQuery();
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On persist modify more then 1 record: " + count);
            }
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            return keys.getInt(1);
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public T getByPK(int key) throws PersistException{
        List<T> list;
        String sql = getSelectQuery();
        sql += WHERE_ID;
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql)){
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e){
            throw new PersistException(e);
        }
        if (list == null || list.size() == 0){
            return null;
        }
        if (list.size() > 1){
            throw new  PersistException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public void update(T object) throws PersistException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql)) {
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public void delete(T object) throws PersistException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql)) {
            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
                throw new PersistException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public List<T> getAll() throws PersistException {
        return get(";");
    }

    @Override
    public List<T> get(String options) throws PersistException {
        List<T> list;
        String sql = getSelectQuery() + options;
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql)){
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

}
