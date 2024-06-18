package pl.programista1024.demos.jpa;

import pl.programista1024.demos.jpa.dataservice.MovieService;
import pl.programista1024.demos.jpa.model.Movie;

public class App {

	public static void main(String[] args) {
		System.out.println("PROGRAMISTA1024.PL (c) 2024");

		App app = new App();
		app.testMovieService();
		
	}
	
	private void testMovieService() {
		MovieService movieService = new MovieService();
		
		// Create movies
		Movie m1 = new Movie(2024, "Garfield", "Mark Dindal", 101);
		Movie m2 = new Movie(2024, "Furiosa: Saga Mad Max", "George Miller", 148);
		Movie m3 = new Movie(2023, "Jedno życie", "James Hawes", 110);
		movieService.createMovie(m1);
		movieService.createMovie(m2);
		movieService.createMovie(m3);
		System.out.println("Movies created.");
		
		// Read and print all movies
		for (Movie movie : movieService.readAllMovies()) {
			System.out.println(movie);
		}
		
		// Update a movie
		Movie movieToUpdate = movieService.readMovie(1L);
		if (movieToUpdate != null) {
			movieService.updateMovie(movieToUpdate.getId(),
					movieToUpdate.getYear(),
					movieToUpdate.getTitle() + " (aktualizacja)",
					movieToUpdate.getDirector(),
					movieToUpdate.getDuration());
			System.out.println("Movie updated.");
		}

		// Read and print all movies again
		for (Movie movie : movieService.readAllMovies()) {
			System.out.println(movie);
		}
		
		// Delete a movie
		movieService.deleteMovie(2L);
		System.out.println("Movie deleted.");

		// Read and print all movies again
		for (Movie movie : movieService.readAllMovies()) {
			System.out.println(movie);
		}

	}

}
