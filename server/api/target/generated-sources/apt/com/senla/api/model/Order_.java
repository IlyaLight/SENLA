package com.senla.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, String> orderDetails;
	public static volatile SingularAttribute<Order, Address> address;
	public static volatile SingularAttribute<Order, BigDecimal> totalPrice;
	public static volatile SingularAttribute<Order, Person> person;
	public static volatile ListAttribute<Order, OrderedGoods> goods;
	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, LocalDate> orderDate;
	public static volatile SingularAttribute<Order, String> status;

}

