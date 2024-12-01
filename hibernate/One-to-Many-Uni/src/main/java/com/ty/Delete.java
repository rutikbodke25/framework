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
		
		Bank bank = em.find(Bank.class, 101);
		
		if (bank!=null) {
			et.begin();
			em.remove(bank);
			et.commit();
		}else {
			System.out.println("Not found");
		}
	}
}
