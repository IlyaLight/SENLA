package com.senla.back.dao.realization;

import com.senla.api.model.Goods;
import com.senla.api.model.Goods_;
import com.senla.back.dao.api.IGoodsDao;
import org.springframework.stereotype.Repository;

import javax.persistence.metamodel.SingularAttribute;

@Repository
public class GoodsDao extends AbstractJpaHibernateDao<Goods> implements IGoodsDao {

    @Override
    protected Class getClazz() {
        return Goods.class;
    }

    @Override
    protected SingularAttribute<Goods, Long> mmGetID() {
        return Goods_.id;
    }
}
