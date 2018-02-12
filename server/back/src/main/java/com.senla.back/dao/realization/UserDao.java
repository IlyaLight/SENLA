package com.senla.back.dao.realization;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.UserValidate;
import com.senla.back.dao.api.IUserDao;
import com.senla.back.dao.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

@Repository
public class UserDao extends AbstractJpaHibernateDao<User> implements IUserDao {
    @Override
    public User getUserByLoginPassword(UserValidate userValidate) throws ObjectAvailabilityException {
        Criteria criteria = HibernateUtil.getSession().createCriteria(User.class)
                .add(Restrictions.like("login", userValidate.getLogin()))
                .add(Restrictions.like("pass", userValidate.getPass()));
        UserValidate vUser = (UserValidate) criteria.uniqueResult();
        System.out.println(vUser);
        return null;

    }

}
