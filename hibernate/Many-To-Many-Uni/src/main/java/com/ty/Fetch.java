package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Student student = em.find(Student.class, 101);

		if (student != null) {
			System.out.println("===============Student_Details=================");
			System.out.println(student.getSid());
			System.out.println(student.getName());
			System.out.println(student.getEmail());

			List<Subject> subjects = student.getSubject();
			System.out.println("==============Subjects==========================");
			for (Subject subject : subjects) {
				System.out.println(subject.getSubid());
				System.out.println(subject.getName());
				System.out.println();
			}

		} else {
			System.err.println("Not found");
		}
	}
}
