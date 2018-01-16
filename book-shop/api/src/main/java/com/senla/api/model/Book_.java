package com.senla.api.model;

import com.senla.api.model.Book;
import com.senla.api.model.Order;
import com.senla.api.model.Request;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, Float> price;
	public static volatile SingularAttribute<Book, Date> datePublication;
	public static volatile SingularAttribute<Book, String> name;
	public static volatile SingularAttribute<Book, String> description;
	public static volatile SingularAttribute<Book, Integer> inStock;
	public static volatile SingularAttribute<Book, Integer> id;
	public static volatile ListAttribute<Book, Request> requests;
	public static volatile ListAttribute<Book, Order> orderArrayList;
	public static volatile SingularAttribute<Book, Date> dateIssue;

}

