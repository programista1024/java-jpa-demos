package pl.programista1024.demos.jpa.dataservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pl.programista1024.demos.jpa.model.Movie;

public class MovieService {

	private final EntityManagerFactory emf;

	public MovieService() {
		this.emf = Persistence.createEntityManagerFactory("jpa-crud-demo-pu");
	}
	
	public void createMovie(Movie movie) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(movie);
		em.getTransaction().commit();
		em.close();
	}
	
	public Movie readMovie(Long id) {
		EntityManager em = emf.createEntityManager();
		Movie movie = em.find(Movie.class, id);
		em.close();
		return movie;
	}
	
	public List<Movie> readAllMovies() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m", Movie.class);
		List<Movie> movies = query.getResultList();
		em.close();
		return movies;
	}
	
	public void updateMovie(Long id, int year, String title, String director, int duration) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Movie movie = em.find(Movie.class, id);
		if (movie != null) {
			movie.setYear(year);
			movie.setTitle(title);
			movie.setDirector(director);
			movie.setDuration(duration);
			em.merge(movie);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteMovie(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Movie movie = em.find(Movie.class, id);
		if (movie != null) {
			em.remove(movie);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void close() {
		emf.close();
	}
}
