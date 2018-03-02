package com.senla.back.dao.realization;

import com.senla.api.model.Car;
import com.senla.back.dao.api.ICarDao;
import org.springframework.stereotype.Repository;

import javax.persistence.metamodel.SingularAttribute;

@Repository
public class CarDao extends AbstractJpaHibernateDao<Car> implements ICarDao {
    @Override
    protected Class getClazz() {
        return null;
    }

    @Override
    protected SingularAttribute<Car, Long> mmGetID() {
        return null;
    }
}
