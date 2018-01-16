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

    private static final String ORDER_BY = " order by ";
    private static final String WHERE_ID_PARAM_ID = " where id = :paramId ";


    public abstract String getSelectQuery();

    protected abstract Class getClazz();

    protected abstract SingularAttribute<T, Integer> mmGetID();

    @Override
    public void create(T object) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();
    }

    @Override
    public T getByPK(int key) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(getClazz())
//                .add(Restrictions.eq("id", key));
//        T t = (T)criteria.uniqueResult();
//        session.close();
//        return t;
        CriteriaBuilder builder = HibernateUtil.getEm().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery( getClazz() );
        Root<T> root = criteria.from( getClazz() );
        criteria.select( root )
            .where(builder.equal(root.get(mmGetID()), key));
        return (T)HibernateUtil.getEm().createQuery(criteria).getSingleResult();

//        return (T)HibernateUtil.getEm().createQuery(getSelectQuery() + WHERE_ID_PARAM_ID)
//                .setParameter("paramId", key)
//                .getSingleResult();
    }

    @Override
    public void update(T object) {
        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();

//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.update(object);
//        session.getTransaction().commit();
    }

    @Override
    public void delete(T object) {
        CriteriaBuilder builder = HibernateUtil.getEm().getCriteriaBuilder();
        CriteriaDelete<T> criteria = builder.createCriteriaDelete( getClazz() );
        Root<T> root = criteria.from( getClazz() );
        criteria.where(builder.equal(root.get(mmGetID()), object.getId()));

//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.delete(object);
//        session.getTransaction().commit();
    }

    @Override
    public List getAll(String sortingColumn) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        List tList = session.createCriteria(getClazz())
//                .addOrder(Order.asc(sortingColumn))
//                .list();
//        session.close();
//        return tList;

        CriteriaBuilder builder = HibernateUtil.getEm().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery( getClazz() );
        Root<T> root = criteria.from( getClazz() );
        criteria.select( root )
            .groupBy(root.get(sortingColumn));
        return HibernateUtil.getEm().createQuery(criteria).getResultList();

            //return HibernateUtil.getEm().createQuery(ORDER_BY + sortingColumn).getResultList();


    }
}
