package pl.edu.pjwstk.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import javax.inject.Inject;

import pl.edu.pjwstk.domain.Movie;
import pl.edu.pjwstk.service.MovieManager;


@SessionScoped
@Named("movieBean")
public class MovieFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Movie movie = new Movie();
	private ListDataModel<Movie> movies = new ListDataModel<Movie>();

	@Inject
	private MovieManager mm;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public ListDataModel<Movie> getAllMovies() {
		movies.setWrappedData(mm.getAllMovies());
		return movies;
	}

	// Actions
	public String addMovie() {
		mm.addMovie(movie);
		return "list_movies"; //list_movies.xhtml
	}

	public String deleteMovie() {
		Movie movieToDelete = movies.getRowData();
		mm.deleteMovie(movieToDelete);
		return null;
	}
}
