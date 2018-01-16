package com.senla.api.model;

import com.senla.api.model.Book;
import com.senla.api.model.Order;
import com.senla.api.model.Order.Status;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile ListAttribute<Order, Book> books;
	public static volatile SingularAttribute<Order, Float> price;
	public static volatile SingularAttribute<Order, Date> dataCompletion;
	public static volatile SingularAttribute<Order, String> details;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile SingularAttribute<Order, Boolean> completed;
	public static volatile SingularAttribute<Order, Status> status;

}

