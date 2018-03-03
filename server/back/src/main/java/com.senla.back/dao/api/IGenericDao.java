package com.senla.back.dao.api;

import com.senla.api.exception.ObjectAvailabilityException;
import org.hibernate.Session;

import java.util.List;

public interface IGenericDao<T> {

    Session getSession();

    public void create(T t) ;

    public T getByPk(Long key) throws ObjectAvailabilityException;

    public void  update(T t) ;

    public void delete(T t) ;

    public List<T> getAll(String sortingColumn);

}
