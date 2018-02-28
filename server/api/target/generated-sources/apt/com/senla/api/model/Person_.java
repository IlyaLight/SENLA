package com.senla.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ {

	public static volatile ListAttribute<Person, Car> cars;
	public static volatile ListAttribute<Person, Address> addresses;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile ListAttribute<Person, Order> orders;
	public static volatile SingularAttribute<Person, Long> id;
	public static volatile SingularAttribute<Person, String> email;
	public static volatile MapAttribute<Person, Goods, Integer> cart;
	public static volatile SingularAttribute<Person, String> status;

}

