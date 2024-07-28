package pl.programista1024.demos.jpa.listeners;

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
		System.out.println("Listeners Example");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("listeners-demo-pu");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		Article article = new Article("Albert Einstein - Relativity");
		entityManager.persist(article);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}
