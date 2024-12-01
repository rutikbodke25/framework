package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Review review = em.find(Review.class, 01);
		if (review != null) {
			et.begin();
			review.setMessage("Bad Product");
			em.merge(review);
			Product product = review.getProduct();
			product.setName("MotoRola");
			em.merge(product);
			et.commit();
		} else {
			System.err.println("Not found");
		}
	}
}
