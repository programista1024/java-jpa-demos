package pl.programista1024.demos.jpa.many_to_many;

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
		System.out.println("Many-To-Many Example");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("relationships-demo-pu");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		Professor professor1 = new Professor("Stephen Hawking");
		Professor professor2 = new Professor("Albert Einstein");
		
		ResearchProject project1 = new ResearchProject("Black Hole Project");
		ResearchProject project2 = new ResearchProject("Quantum Field Theory Project");
		ResearchProject project3 = new ResearchProject("Thermodynamic Fluctuations Project");
		
		professor1.assignProjectToProfessor(project1);
		professor1.assignProjectToProfessor(project2);
		professor2.assignProjectToProfessor(project3);
		professor2.assignProjectToProfessor(project1);
		
		project1.assignProfessorToProject(professor1);
		project1.assignProfessorToProject(professor2);
		project2.assignProfessorToProject(professor1);
		project3.assignProfessorToProject(professor2);
		
		entityManager.persist(professor1);
		entityManager.persist(professor2);
		entityManager.persist(project1);
		entityManager.persist(project2);
		entityManager.persist(project3);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}
