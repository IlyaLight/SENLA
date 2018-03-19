package com.senla.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Car.class)
public abstract class Car_ {

	public static volatile SingularAttribute<Car, String> typeOfFuel;
	public static volatile ListAttribute<Car, Person> persons;
	public static volatile SingularAttribute<Car, Integer> year;
	public static volatile ListAttribute<Car, Goods> suitableGoods;
	public static volatile SingularAttribute<Car, String> model;
	public static volatile SingularAttribute<Car, Long> Id;
	public static volatile SingularAttribute<Car, String> brand;
	public static volatile SingularAttribute<Car, Float> engineCapacity;

}

