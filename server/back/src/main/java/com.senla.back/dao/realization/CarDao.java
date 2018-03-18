package com.senla.back.dao.realization;

import com.senla.api.model.Car;
import com.senla.api.model.Car_;
import com.senla.back.dao.api.ICarDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;

@Repository
public class CarDao extends AbstractJpaHibernateDao<Car> implements ICarDao {
    private static final String ID_LIST = "idList";
    private static final String GET_BY_ID_QUERY = "from " +Car.class.getSimpleName() + " D where D.id in :" + ID_LIST;

    @Override
    protected Class getClazz() {
        return Car.class;
    }

    @Override
    protected SingularAttribute<Car, Long> mmGetID() {
        return Car_.Id;
    }

    @Override
    public List<Car> getById(List<Long> idList){
       Query query = getSession().createQuery(GET_BY_ID_QUERY).setParameter(ID_LIST, idList);
        return query.getResultList();
    }

}
