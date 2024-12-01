package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Review review = em.find(Review.class, 201);
		Product product = review.getProduct();

		if (review != null) {
			et.begin();
			em.remove(product);
			et.commit();
		} else {
			System.out.println("Not found");
		}
	}
}
