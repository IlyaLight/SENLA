package com.senla.back.dao.realization;

import com.senla.api.model.Address;
import com.senla.api.model.Address_;
import com.senla.back.dao.api.IAddressDao;
import org.springframework.stereotype.Repository;

import javax.persistence.metamodel.SingularAttribute;

@Repository
public class AddressDao extends AbstractJpaHibernateDao<Address> implements IAddressDao {
    @Override
    protected Class getClazz() {
        return Address.class;
    }

    @Override
    protected SingularAttribute<Address, Long> mmGetID() {
        return Address_.id;
    }
}
