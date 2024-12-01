package com.ty;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = new Student();
		student.setSid(101);
		student.setName("Rahul");
		student.setEmail("romeodm17@gmail.com");

		Subject subject1 = new Subject();
		subject1.setSubid(111);
		subject1.setName("JAVA");

		Subject subject2 = new Subject();
		subject2.setSubid(222);
		subject2.setName("SQL");

		Subject subject3 = new Subject();
		subject3.setSubid(333);
		subject3.setName("JAVASCRIPT");

		student.setSubject(Arrays.asList(subject1, subject2, subject3));

		et.begin();
		em.persist(student);
		em.persist(subject1);
		em.persist(subject2);
		em.persist(subject3);
		et.commit();
	}
}
