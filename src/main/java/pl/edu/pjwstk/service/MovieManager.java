package pl.edu.pjwstk.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.edu.pjwstk.domain.Movie;


@Stateless
public class MovieManager {
	@PersistenceContext
	EntityManager em;

	public void addMovie(Movie movie) {
		movie.setId(null);
		em.persist(movie);
	}

	public void deleteMovie(Movie movie) {
		movie = em.find(Movie.class, movie.getId());
		em.remove(movie);
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies() {
		return em.createNamedQuery("movie.all").getResultList();
	}
}
