package com.senla.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> address;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, Person> person;
	public static volatile SingularAttribute<Address, Integer> postCode;
	public static volatile ListAttribute<Address, Order> orders;
	public static volatile SingularAttribute<Address, Long> id;

}

