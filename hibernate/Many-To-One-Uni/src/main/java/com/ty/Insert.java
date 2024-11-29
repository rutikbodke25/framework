package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	 Product product1 = new Product(111,"Samsung",9666666);
	
	 Review review1 = new Review(101,"Good Mobile");
	 review1.setProduct(product1);
	 Review review2 = new Review(201,"Awsm Battery");
	 review2.setProduct(product1);
	 
	 et.begin();
	 em.persist(review1);
	 em.persist(review2);
	 em.persist(product1);
	 et.commit();
	 
	 
}
}
