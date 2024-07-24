package pl.programista1024.demos.jpa.one_to_one;

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
		
		Address address = new Address();
		address.setAddressName("Wall Street");
		address.setZipCode(111);
		
		Employee employee = new Employee();
		employee.setEmployeeName("Joe Smith");
		employee.setAddress(address);
		
		address.setEmployee(employee);
		
		entityManager.persist(employee);
		entityManager.persist(address);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}
