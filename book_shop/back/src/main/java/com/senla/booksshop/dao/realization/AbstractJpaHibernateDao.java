package com.senla.booksshop.dao.realization;

import com.senla.api.model.IModel;
import com.senla.booksshop.dao.api.IGenericDao;
import com.senla.booksshop.utility.HibernateUtil;
import org.hibernate.Transaction;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public abstract class AbstractJpaHibernateDao<T extends IModel, PK> implements IGenericDao<T, PK> {

    private static final String ORDER_BY = " order by ";

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    @Override
    public void create(T object) {

    }

    @Override
    public T getByPK(int key) {
        return null;
    }

    @Override
    public void update(T object) {

    }

    @Override
    public void delete(T object) {
        EntityManager entityManager = HibernateUtil.getEm();
        entityManager.getTransaction().begin();
        entityManager.createQuery(getDeleteQuery())
            .setParameter("paramId", object.getId())
            .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public List getAll(String... sortingColumn) {
        StringBuilder query = new StringBuilder(getSelectQuery());
        if(sortingColumn.length > 0) {
            query.append(ORDER_BY);
            for (int i = 0; i < sortingColumn.length - 2; i++) {
                query.append(sortingColumn[i]);
                query.append(", ");
            }
            query.append(sortingColumn[sortingColumn.length - 1]);
        }
        return HibernateUtil.getEm().createQuery(query.toString()).getResultList();

    }
}
