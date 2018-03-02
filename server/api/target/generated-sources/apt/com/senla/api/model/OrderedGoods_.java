package com.senla.api.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderedGoods.class)
public abstract class OrderedGoods_ {

	public static volatile SingularAttribute<OrderedGoods, String> characteristics;
	public static volatile SingularAttribute<OrderedGoods, String> imgLink;
	public static volatile SingularAttribute<OrderedGoods, Integer> quantity;
	public static volatile SingularAttribute<OrderedGoods, BigDecimal> price;
	public static volatile SingularAttribute<OrderedGoods, String> name;
	public static volatile SingularAttribute<OrderedGoods, String> description;
	public static volatile SingularAttribute<OrderedGoods, Goods> goods;
	public static volatile SingularAttribute<OrderedGoods, Long> id;
	public static volatile SingularAttribute<OrderedGoods, String> category;
	public static volatile SingularAttribute<OrderedGoods, Order> order;

}

