package com.qa.business.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Transactional(SUPPORTS)
@Alternative
public class MovieMapRepository implements IMovieRepository{

	private Map<Long, Movie> movieMap = new HashMap<Long, Movie>();
	private Long ID = 1L;
	
	private void initMovietMap() {
		Movie movie = new Movie("Joe", "Bloggs", "1234");
		movieMap.put(1L, movie);
	}
	
	@PersistenceContext(unitName = "primary")
    private EntityManager manager;
	
	@Inject
    private JSONUtil util;
	

	public String getAllMovies() {
		return util.getJSONForObject(movieMap.values());
	}


	public String getAMovie(Long id) {
		
		return null;
	}


	@Transactional(REQUIRED)
	public String createMovie(String movieJSON) {
		initMovietMap();
		ID = ID + 2;
		Movie aMovie = util.getObjectForJSON(movieJSON, Movie.class);
		movieMap.put(ID, aMovie);
		return "{\"Account Created\"}";
			
		}
	

	@Transactional(REQUIRED)
	public String deleteMovie(Long id) {
		Movie aMovie = manager.find(Movie.class, id);
    	if (aMovie != null) {
    		movieMap.remove(aMovie);
    		return "{\"Account Deleted\"}";
		}
		else {
			return "{\"Cant Delete\":\" Account does not exist\"}";
		}
	}

	@Transactional(REQUIRED)
	public String updateMovie(String movieJSON) {
		Movie aMovie = util.getObjectForJSON(movieJSON, Movie.class);
		movieMap.put(aMovie.getId(), aMovie);
		return "{\"message\": \"account sucessfully updated\"}";
	}

}
