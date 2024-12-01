package com.ty;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertStud2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = new Student();
		student.setSid(102);
		student.setName("Ashhh");
		student.setEmail("Ashley@gmail.com");

		Subject subject1 = em.find(Subject.class, 111);
		Subject subject2 = em.find(Subject.class, 222);

		Subject subjectHtml = new Subject();
		subjectHtml.setSubid(444);
		subjectHtml.setName("HTML");

		student.setSubject(Arrays.asList(subject1, subject2, subjectHtml));

		et.begin();
		em.persist(student);
		em.persist(subjectHtml);
		et.commit();
	}
}
