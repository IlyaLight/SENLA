package com.senla.booksshop.dao.realization;

import com.senla.api.model.Book;
import com.senla.api.model.Book_;
import com.senla.booksshop.dao.api.IBookDao;

import com.senla.booksshop.utility.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.SingularAttribute;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HibernateBookDao extends AbstractJpaHibernateDao<Book, Integer> implements IBookDao {

    private static final String ENTITY              = Book.class.getSimpleName();
    private static final String SELECT_QUERY        = "FROM " + ENTITY ;

    private static final String STALE_BOOKS         = SELECT_QUERY + "WHERE date_issue < :pDate_issue ORDER BY :columnName";
    private static final String RECEIVED_LATER_THAN = SELECT_QUERY + "WHERE date_publication > :pDate_publication ORDER BY :columnName";
    private static final String BY_NAME             = SELECT_QUERY + "WHERE name = :name ORDER BY :columnName";

    private static final String ERROR               = "Dao Error:";
    private static final Logger LOGGER              = LoggerFactory.getLogger(HibernateBookDao.class);

    @Override
    public List<Book> getStaleBooks(Date data, String columnName) {
        Map<String,Object> parametersMap = new HashMap<>();
        parametersMap.put("pDate_issue", data);
        parametersMap.put("columnName", columnName);
        return getBooksList(STALE_BOOKS, parametersMap);
//        return HibernateUtil.getEm().createQuery(STALE_BOOKS + columnName)
//                .setParameter("pDate_issue", data)
//                .getResultList();
    }

    @Override
    public List<Book> booksReceivedLaterThan(Date data, String columnName) {
        Map<String,Object> parametersMap = new HashMap<>();
        parametersMap.put("pDate_publication", data);
        parametersMap.put("columnName", columnName);
        return getBooksList(RECEIVED_LATER_THAN, parametersMap);
//        return HibernateUtil.getEm().createQuery(RECEIVED_LATER_THAN + columnName)
//                .setParameter("pDate_publication", data)
//                .getResultList();
    }

    @Override
    public List<Book> getBookByName(String name) {
        Map<String,Object> parametersMap = new HashMap<>();
        parametersMap.put("name", name);
        parametersMap.put("columnName", "id");
        return getBooksList(RECEIVED_LATER_THAN, parametersMap);
    }

    private List<Book> getBooksList(String query, Map<String,Object> parametersMap){
        Query query1 = HibernateUtil.getEntityManager().createQuery(RECEIVED_LATER_THAN );
        for (Map.Entry<String, Object> entry : parametersMap.entrySet()) {
            query1.setParameter(entry.getKey(), entry.getValue());
        }
        return query1.getResultList();

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

