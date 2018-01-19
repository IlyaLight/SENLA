package com.senla.booksshop.dao.realization;

import com.senla.api.model.Request;
import com.senla.api.model.Request_;
import com.senla.booksshop.dao.api.IRequestDao;

import javax.persistence.metamodel.SingularAttribute;

public class HibernateRequestDao  extends AbstractJpaHibernateDao<Request,Integer> implements IRequestDao {
    private static final String ENTITY              = Request.class.getSimpleName();
    private static final String SELECT_QUERY        = "FROM " + ENTITY ;

    @Override
    public String getSelectQuery() {
        return ENTITY;
    }

    @Override
    protected Class getClazz() {
        return Request_.class;
    }

    @Override
    protected SingularAttribute<Request, Integer> mmGetID() {
        return Request_.id;
    }
}
