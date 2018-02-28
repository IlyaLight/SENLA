package com.senla.api.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Goods.class)
public abstract class Goods_ {

	public static volatile ListAttribute<Goods, Car> cars;
	public static volatile SingularAttribute<Goods, String> characteristics;
	public static volatile SingularAttribute<Goods, String> imgLink;
	public static volatile SingularAttribute<Goods, BigDecimal> price;
	public static volatile SingularAttribute<Goods, String> name;
	public static volatile SingularAttribute<Goods, String> description;
	public static volatile SingularAttribute<Goods, Integer> inStock;
	public static volatile SingularAttribute<Goods, Long> id;
	public static volatile SingularAttribute<Goods, String> category;

}

