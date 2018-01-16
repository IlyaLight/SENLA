package com.senla.api.model;

import com.senla.api.model.Book;
import com.senla.api.model.Request;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Request.class)
public abstract class Request_ {

	public static volatile SingularAttribute<Request, Integer> quantity;
	public static volatile SingularAttribute<Request, Book> book;
	public static volatile SingularAttribute<Request, Integer> id;

}

