package com.senla.booksshop.dao.realization;

import com.senla.api.exception.ObjectAvailabilityException;
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
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;

public abstract class AbstractJpaHibernateDao<T extends IModel, PK> implements IGenericDao<T, PK> {


    private static final String ERROR_GET_BY_KEY = "не найден объект с key = ";

    public abstract String getSelectQuery();

    protected abstract Class getClazz();

    protected abstract SingularAttribute<T, Integer> mmGetID();

    @Override
    public void create(T object) {
       EntityManager em = HibernateUtil.getEm();

       // if (em.getTransaction().isActive()){
         //   em.persist(object);
           // return;
       // }
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public T getByPK(int key) throws ObjectAvailabilityException {

        CriteriaBuilder builder = HibernateUtil.getEm().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery( getClazz() );
        Root<T> root = criteria.from( getClazz() );
        criteria.select( root )
            .where(builder.equal(root.get(mmGetID()), key));
        try {
        return HibernateUtil.getEm().createQuery(criteria).getSingleResult();
        }catch (NoResultException e){
            throw  new ObjectAvailabilityException(ERROR_GET_BY_KEY + key);
        }

    }

    @Override
    public void update(T object) {
        EntityManager em = HibernateUtil.getEm();
        if(em.isOpen()){
            em.merge(object);
            return;
        }
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T object) {
        EntityManager em = HibernateUtil.getEm();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaDelete<T> criteria = builder.createCriteriaDelete(getClazz());
        Root<T> root = criteria.from(getClazz());
        if(em.getTransaction().isActive()) {
            criteria.where(builder.equal(root.get(mmGetID()), object.getId()));
            return;
        }
        em.getTransaction().begin();
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
