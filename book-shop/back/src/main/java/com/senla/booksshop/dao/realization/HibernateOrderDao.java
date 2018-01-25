package com.senla.booksshop.dao.realization;

import com.senla.api.model.Order;
import com.senla.api.model.Order_;
import com.senla.booksshop.dao.api.IOrderDao;
import com.senla.booksshop.utility.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.metamodel.SingularAttribute;
import java.util.Date;
import java.util.List;

public class HibernateOrderDao extends AbstractJpaHibernateDao<Order, Integer> implements IOrderDao {

    private static final String ENTITY              = Order.class.getSimpleName();
    private static final String SELECT_QUERY        = "FROM " + ENTITY ;

    private static final String COMPLETED_ORDER = SELECT_QUERY + "WHERE date_issue > :pFrom AND date_issue < :pTo AND completed = TRUE ORDER BY ;";

    private static final String ERROR               = "Dao Error:";
    private static final Logger LOGGER              = LoggerFactory.getLogger(HibernateOrderDao.class);

    @Override
    public String getSelectQuery() {
        return ENTITY;
    }

    @Override
    public List<Order> getCompletedOrder(Date from, Date to, String sortingColumn) {
        return HibernateUtil.getEntityManager().createQuery(COMPLETED_ORDER + sortingColumn)
                .setParameter("pFrom", from)
                .setParameter("pTo", to)
                .getResultList();
    }

    @Override
    protected Class getClazz() {
        return Order.class;
    }

    @Override
    protected SingularAttribute<Order, Integer> mmGetID() {
        return Order_.id;
    }

}
