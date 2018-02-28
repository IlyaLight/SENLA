package com.senla.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Login.class)
public abstract class Login_ {

	public static volatile SingularAttribute<Login, String> password;
	public static volatile SingularAttribute<Login, Person> person;
	public static volatile SingularAttribute<Login, Long> id;
	public static volatile SingularAttribute<Login, String> login;

}

