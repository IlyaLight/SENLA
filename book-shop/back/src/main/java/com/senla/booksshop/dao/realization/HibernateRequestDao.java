package com.senla.booksshop.dao.realization;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Request;
import com.senla.api.model.Request_;
import com.senla.booksshop.dao.api.IRequestDao;
import com.senla.booksshop.utility.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.metamodel.SingularAttribute;

public class HibernateRequestDao  extends AbstractJpaHibernateDao<Request,Integer> implements IRequestDao {
    private static final String ENTITY              = Request.class.getSimpleName();
    private static final String SELECT_QUERY        = "FROM " + ENTITY ;
    private static final String GET_BY_BOOK_ID = SELECT_QUERY + " WHERE book_id = :pBook_id";

    @Override
    public String getSelectQuery() {
        return ENTITY;
    }

    @Override
    protected Class getClazz() {
        return Request.class;
    }

    @Override
    protected SingularAttribute<Request, Integer> mmGetID() {
        return Request_.id;
    }

    @Override
    public Request getRequestByBookId(Integer bookId) throws ObjectAvailabilityException {
        try {
            return (Request) HibernateUtil.getEm().createQuery(GET_BY_BOOK_ID)
                    .setParameter("pBook_id", bookId)
                    .getSingleResult();
        }catch (NoResultException e) {
            throw new ObjectAvailabilityException("не найдена запрос на книгу с id = " + bookId);
        }
    }
}
