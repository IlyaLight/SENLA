package com.senla.back.dao.realization;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.back.dao.api.IGenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;


public abstract class AbstractJpaHibernateDao<T> implements IGenericDao<T> {


    private static final String ERROR_GET_BY_KEY = "не найден объект с key = ";

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void create(T object) {
       getSession().save(object);
    }

    @Override
    public T getByPk(Integer key) throws ObjectAvailabilityException {

        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery( getClazz() );
        Root<T> root = criteria.from( getClazz() );
        criteria.select( root )
            .where(builder.equal(root.get(mmGetID()), key));
        try {
        return getSession().createQuery(criteria).getSingleResult();
        }catch (NoResultException e){
            throw  new ObjectAvailabilityException(ERROR_GET_BY_KEY + key);
        }
    }

    @Override
    public void update(T object) {
//        EntityManager em = HibernateUtil.getEntityManager();
//        if(em.getTransaction().isActive()){
//            em.merge(object);
//            return;
//        }
//        em.getTransaction().begin();
//        em.merge(object);
//        em.getTransaction().commit();
    }

    @Override
    public void delete(T object) {

    }

    @Override
    public List getAll(String sortingColumn) {

//        CriteriaBuilder builder = HibernateUtil.getEntityManager().getCriteriaBuilder();
//        CriteriaQuery<T> criteria = builder.createQuery( getClazz() );
//        Root<T> root = criteria.from( getClazz() );
//        criteria.select( root )
//            .groupBy(root.get(sortingColumn));
//        return HibernateUtil.getEntityManager().createQuery(criteria).getResultList();
        return null;

    }

    protected abstract Class getClazz();

    protected abstract SingularAttribute<T, Long> mmGetID();
}
