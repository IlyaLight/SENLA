package com.senla.booksshop.dao.realization;

import com.senla.api.model.IModel;
import com.senla.booksshop.dao.api.IGenericDao;
import com.senla.booksshop.utility.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;

public abstract class AbstractJpaHibernateDao<T extends IModel, PK> implements IGenericDao<T, PK> {


    public abstract String getSelectQuery();

    protected abstract Class getClazz();

    protected abstract SingularAttribute<T, Integer> mmGetID();

    @Override
    public void create(T object) {
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public T getByPK(int key) {

        CriteriaBuilder builder = HibernateUtil.getEm().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery( getClazz() );
        Root<T> root = criteria.from( getClazz() );
        criteria.select( root )
            .where(builder.equal(root.get(mmGetID()), key));
        return HibernateUtil.getEm().createQuery(criteria).getSingleResult();

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
        CriteriaBuilder builder = HibernateUtil.getEm().getCriteriaBuilder();
        HibernateUtil.getEm().getTransaction().begin();
        CriteriaDelete<T> criteria = builder.createCriteriaDelete( getClazz() );
        Root<T> root = criteria.from( getClazz() );
        criteria.where(builder.equal(root.get(mmGetID()), object.getId()));
        HibernateUtil.getEm().getTransaction().commit();
    }

    @Override
    public List getAll(String sortingColumn) {

        CriteriaBuilder builder = HibernateUtil.getEm().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery( getClazz() );
        Root<T> root = criteria.from( getClazz() );
        criteria.select( root )
            .groupBy(root.get(sortingColumn));
        return HibernateUtil.getEm().createQuery(criteria).getResultList();

    }
}
