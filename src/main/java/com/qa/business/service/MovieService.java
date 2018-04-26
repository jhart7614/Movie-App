package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IMovieRepository;

public class MovieService implements IMovieService {

	@Inject
	private IMovieRepository repo;

	public String getAllMovies() {
		return repo.getAllMovies();
	}

	public String getAMovie(Long id) {
		return repo.getAMovie(id);
	}

	public String createMovie(String jsonMovie) {
		return repo.createMovie(jsonMovie);
	}

	public String deleteMovie(Long id) {
		return repo.deleteMovie(id);
	}
	
	public String updateMovie(String jsonMovie) {
		return repo.updateMovie(jsonMovie);
	}

}
