package com.senla.booksshop.dao.realization.hibernate;

import com.senla.api.model.Request;
import com.senla.booksshop.dao.api.IRequestDao;

public class HibernateRequestDao  extends AbstractJpaHibernateDao<Request,Integer> implements IRequestDao {
    private static final String ENTITY              = Request.class.getSimpleName();
    private static final String SELECT_QUERY        = "FROM " + ENTITY ;

    @Override
    public String getSelectQuery() {
        return ENTITY;
    }
}
