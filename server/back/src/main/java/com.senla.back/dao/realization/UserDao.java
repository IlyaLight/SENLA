package com.senla.back.dao.realization;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.User_;
import com.senla.api.model.Validate;
import com.senla.back.dao.api.IUserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.metamodel.SingularAttribute;

@Repository
public class UserDao extends AbstractJpaHibernateDao<User> implements IUserDao {
    @Override
    public User getUserByLoginPassword(Validate validate) throws ObjectAvailabilityException {
        return null;
    }

    @Override
    protected Class getClazz() {
        return User.class;
    }

    @Override
    protected SingularAttribute<User, Integer> mmGetID() {
        return User_.id;
    }
}
