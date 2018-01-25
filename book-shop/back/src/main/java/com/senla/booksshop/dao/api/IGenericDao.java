package com.senla.booksshop.dao.api;

import com.senla.api.exception.ObjectAvailabilityException;

import java.util.List;

public interface IGenericDao<T, PK> {

    public void create(T t) ;

    public T getByPK(int key) throws ObjectAvailabilityException;

    public void  update(T t) ;

    public void delete(T t) ;

    public List<T> getAll(String sortingColumn);

}
