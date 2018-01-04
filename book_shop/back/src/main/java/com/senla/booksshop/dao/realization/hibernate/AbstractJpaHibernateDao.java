package com.senla.booksshop.dao.realization.hibernate;

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
    private static final String WHERE_ID_PARAM_ID = " where id = :paramId ";


    public abstract String getSelectQuery();

    @Override
    public void create(T object) {
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public T getByPK(int key) {
        return (T)HibernateUtil.getEm().createQuery(getSelectQuery() + WHERE_ID_PARAM_ID)
                .setParameter("paramId", key)
                .getSingleResult();
    }

    @Override
    public void update(T object) {
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T object) {
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
//        em.createQuery(getDeleteQuery())
//            .setParameter("paramId", object.getId())
//            .executeUpdate();
        em.remove(em.contains(object)? object : em.merge(object));
        em.getTransaction().commit();
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
