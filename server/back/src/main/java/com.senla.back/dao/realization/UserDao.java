package com.senla.back.dao.realization;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.UserValidate;
import com.senla.api.model.UserValidate_;
import com.senla.api.model.User_;
import com.senla.back.dao.api.IUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

@Repository
@Transactional
public class UserDao extends AbstractJpaHibernateDao<User> implements IUserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    @Override
    protected Class getClazz() {
        return User.class;
    }

    @Override
    protected SingularAttribute<User, Long> mmGetID() {
        return User_.id;
    }

    @Override
    public User getUserByLoginPassword(UserValidate userValidate) throws ObjectAvailabilityException {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<UserValidate> criteria = builder.createQuery( UserValidate.class );
        Root<UserValidate> root = criteria.from( UserValidate.class );
        criteria.select( root ).where(
                builder.and(
                        builder.equal(root.get(UserValidate_.login), userValidate.getLogin()),
                        builder.equal(root.get(UserValidate_.pass), userValidate.getPass())));
        try {
            UserValidate resp = getSession().createQuery(criteria).getSingleResult();
            return resp.getUser();
        }catch (NoResultException e){
            throw  new ObjectAvailabilityException();
        }
    }

}
