package pl.programista1024.demos.jpa;

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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("relationships-demo-pu");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}
