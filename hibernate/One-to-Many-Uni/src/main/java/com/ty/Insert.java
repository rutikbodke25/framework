package com.ty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bank bank = new Bank(101, "SBI");

		Account account1 = new Account(111, "A");

		Account account2 = new Account(222, "B");

//		List<Account> account = new ArrayList<>();
//		account.add(account1);
//		account.add(account2);
//		bank.setAccount(account);

		bank.setAccount(Arrays.asList(account1, account2));

		et.begin();
		em.persist(bank);
		em.persist(account1);
		em.persist(account2);
		et.commit();

	}
}
