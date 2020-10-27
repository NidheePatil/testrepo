package org.nidhee.java2blog.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile ListAttribute<Customer, Address> address;
	public static volatile SingularAttribute<Customer, UUID> id;
	public static volatile SingularAttribute<Customer, String> customerName;
	public static volatile SingularAttribute<Customer, String> email;

	public static final String ADDRESS = "address";
	public static final String ID = "id";
	public static final String CUSTOMER_NAME = "customerName";
	public static final String EMAIL = "email";

}

