package com.senla.back.dao.api;

import com.senla.api.exception.ObjectAvailabilityException;

import java.util.List;

public interface IGenericDao<T> {

    public void create(T t) ;

    public T getByPk(int key) throws ObjectAvailabilityException;

    public void  update(T t) ;

    public void delete(T t) ;

    public List<T> getAll(String sortingColumn);

}
