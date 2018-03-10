package com.senla.back.dao.realization;

import com.senla.api.model.Login;
import com.senla.api.model.Login_;
import com.senla.back.dao.api.ILoginDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

@Repository
public class LoginDao extends AbstractJpaHibernateDao<Login> implements ILoginDao {


    @Override
    protected Class getClazz() {
        return Login.class;
    }

    @Override
    protected SingularAttribute<Login, Long> mmGetID() {
        return Login_.id;
    }

    @Override
    public boolean checkLoginDuplicate(Login login){
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Login> criteria = builder.createQuery( Login.class );
        Root<Login> root = criteria.from( Login.class );
        criteria.select( root ).where(
                        builder.equal(root.get(Login_.login), login.getLogin()));
        try {
            getSession().createQuery(criteria).getSingleResult();
            return true;
        }catch (NoResultException e){
            return false;
        }
    }
}
