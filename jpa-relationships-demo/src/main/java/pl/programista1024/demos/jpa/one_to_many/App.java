package pl.programista1024.demos.jpa.one_to_many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		System.out.println("PROGRAMISTA1024.PL (c) 2024");

		App app = new App();
		app.go();
	}

	private void go() {
		System.out.println("One to many example");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("relationships-demo-pu");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		University university = new University("Politechnika Warszawska");

		Student s1 = new Student();
		s1.setStudentName("Kevin");
		s1.setUniversity(university);

		Student s2 = new Student();
		s2.setStudentName("Joe");
		s2.setUniversity(university);

		entityManager.persist(university);
		entityManager.persist(s1);
		entityManager.persist(s2);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}
