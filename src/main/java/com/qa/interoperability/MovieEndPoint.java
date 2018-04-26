package com.qa.interoperability;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IMovieService;

@Path("/movie")
public class MovieEndPoint {

	@Inject
	private IMovieService service;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getAllMovies() {
		return service.getAllMovies();
	}

	@GET
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String getMovies(@PathParam("id") Long id) {
		return service.getAMovie(id);
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String createMovies(String jsonString) {
		return service.createMovie(jsonString);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteMovies(@PathParam("id") Long id) {
		return service.deleteMovie(id);
	}
	
	@PUT
	@Path("/json/")
	@Produces({ "application/json" })
	public String updateMovies( String jsonString) {
		return service.updateMovie(jsonString);
	}
}
