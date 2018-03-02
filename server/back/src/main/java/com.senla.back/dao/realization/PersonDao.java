package com.senla.back.dao.realization;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Login;
import com.senla.api.model.Login_;
import com.senla.api.model.Person;
import com.senla.api.model.Person_;
import com.senla.back.dao.api.IPersonDao;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;


@Repository
public class PersonDao  extends AbstractJpaHibernateDao<Person> implements IPersonDao {

    @Override
    protected Class getClazz() {
        return Person.class;
    }

    @Override
    protected SingularAttribute<Person, Long> mmGetID() {
        return Person_.id;
    }

    @Override
    public Person getPersonBuLogin(Login login) throws ObjectAvailabilityException {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Login> criteria = builder.createQuery( Login.class );
        Root<Login> root = criteria.from( Login.class );
        criteria.select( root ).where(
                builder.and(
                        builder.equal(root.get(Login_.login), login.getLogin()),
                        builder.equal(root.get(Login_.password), login.getPassword())));
        try {
            Login resp = getSession().createQuery(criteria).getSingleResult();
            return resp.getPerson();
        }catch (NoResultException e){
            throw  new ObjectAvailabilityException();
        }
    }
}
