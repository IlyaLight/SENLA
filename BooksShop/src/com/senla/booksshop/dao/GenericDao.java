package com.senla.booksshop.dao;

import com.senla.api.model.IModel;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    public T create() throws PersistException;

    public T persist(T t) throws PersistException;

    public T getByPK(int key) throws PersistException;

    public void  update(T t) throws PersistException;

    public void delete(T t) throws PersistException;

    public List<T> getAll() throws PersistException;
}
