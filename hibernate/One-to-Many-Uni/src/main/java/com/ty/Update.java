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

		Bank bank = em.find(Bank.class, 101);

		bank.setName("HSBBCC");

		Account acc1 = em.find(Account.class, 222);
		acc1.setName("D");

		if (bank != null) {
			et.begin();
			em.merge(bank);
			
			if (acc1!=null) {
				
				em.merge(acc1);
			}
			et.commit();

		} else {
			System.out.println("Data not found");
		}
	}
}
