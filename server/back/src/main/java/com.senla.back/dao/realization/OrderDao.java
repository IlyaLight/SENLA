package com.senla.back.dao.realization;

import com.senla.api.model.Order;
import com.senla.back.dao.api.IOrderDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.metamodel.SingularAttribute;

@Repository
public class OrderDao extends AbstractJpaHibernateDao<Order> implements IOrderDao {
    @Override
    protected Class getClazz() {
        return null;
    }

    @Override
    protected SingularAttribute<Order, Long> mmGetID() {
        return null;
    }
}
