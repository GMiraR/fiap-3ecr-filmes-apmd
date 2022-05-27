package br.com.fiap.movies.controller;

import java.util.List;

import br.com.fiap.movies.service.MoviesService;
import br.com.fiap.movies.domain.Movie;
import br.com.fiap.movies.view.WindowView;

public class MovieController {

	MoviesService moviesService;
	WindowView view;
	
	public MovieController(WindowView view) {
		moviesService = new MoviesService();
		this.view = view;
	}

	public List<Movie> listMovies() {
		return moviesService.listAll();
	}

	public void save(String title, String synopsis, String genre, String streaming, boolean wasMovieWatched, int rating) {
		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setSynopsis(synopsis);
		movie.setWasMovieWatched(wasMovieWatched);
		movie.setGenre(genre);
		movie.setStreaming(streaming);
		movie.setRating(rating);
		
		moviesService.insert(movie);
		view.getListing().update();
	}
	
	public void delete(Long id) {
		Movie movie = new Movie();
		movie.setId(id);
		
		moviesService.delete(movie);
		view.getListing().update();
	}



}
