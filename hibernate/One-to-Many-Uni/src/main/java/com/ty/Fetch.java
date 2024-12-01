package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Bank bank = em.find(Bank.class, 101);

		if (bank != null) {
			System.out.println("======================Bank Details===================");
			System.out.println(bank.getBid());
			System.out.println(bank.getName());

			List<Account> accounts = bank.getAccount();

			System.out.println("====================Account Details=================");
			for (Account account : accounts) {
				System.out.println(account.getAcc());
				System.out.println(account.getName());
				System.out.println("-----------------------------------------------");
			}
		}else {
			System.err.println("Not dound");
		}
	}
}
