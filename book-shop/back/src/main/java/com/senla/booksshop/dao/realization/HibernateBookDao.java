package com.senla.booksshop.dao.realization;

import com.senla.api.model.Book;
import com.senla.api.model.Book_;
import com.senla.booksshop.dao.api.IBookDao;

import com.senla.booksshop.utility.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.metamodel.SingularAttribute;
import java.util.Date;
import java.util.List;

public class HibernateBookDao extends AbstractJpaHibernateDao<Book,Integer> implements IBookDao {

    private static final String ENTITY              = Book.class.getSimpleName();
    private static final String SELECT_QUERY        = "FROM " + ENTITY ;

    private static final String STALE_BOOKS         = SELECT_QUERY + " WHERE date_issue > :pDate_issue ORDER BY ";
    private static final String RECEIVED_LATER_THAN = SELECT_QUERY + "WHERE date_publication > :pDate_publication ORDER BY ";

    private static final String ERROR               = "Dao Error:";
    private static final Logger LOGGER              = LoggerFactory.getLogger(HibernateBookDao.class);

    @Override
    public List<Book> getStaleBooks(Date data, String columnName) {
        return HibernateUtil.getEm().createQuery(STALE_BOOKS + columnName)
                .setParameter("pDate_issue", data)
                .getResultList();
    }

    @Override
    public List<Book> booksReceivedLaterThan(Date data, String columnName) {
        return HibernateUtil.getEm().createQuery(RECEIVED_LATER_THAN + columnName)
                .setParameter("pDate_publication", data)
                .getResultList();
    }

    @Override
    public String getSelectQuery() {
        return SELECT_QUERY;
    }

    @Override
    protected Class getClazz() {
        return Book.class;
    }

    @Override
    protected SingularAttribute<Book, Integer> mmGetID() {
        return Book_.id;
    }
}

