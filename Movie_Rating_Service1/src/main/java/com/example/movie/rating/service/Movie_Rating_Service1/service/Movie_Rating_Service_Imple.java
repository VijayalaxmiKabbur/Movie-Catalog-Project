package com.example.movie.rating.service.Movie_Rating_Service1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.movie.rating.service.Movie_Rating_Service1.daoservice.Movie_Rating_Service_Repository;
import com.example.movie.rating.service.Movie_Rating_Service1.model.Movie_Catalog;
import com.example.movie.rating.service.Movie_Rating_Service1.model.Movie_Rating;

@Service
public class Movie_Rating_Service_Imple implements Movie_Rating_Service {
	
	@Autowired
	Movie_Rating_Service_Repository movieratingrepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Movie_Rating addRatingToSpecifiedMovie(int movieId, int userId,int ratingNo) {
		Movie_Catalog catalog = restTemplate.getForObject("http://localhost:8081/movie_catalog/oneHistroy/"+movieId+"/"+userId,Movie_Catalog.class );
		Movie_Rating movierating = new Movie_Rating(movieId,userId,catalog.getMovieName(),ratingNo);
		movieratingrepo.save(movierating);
		return movierating;
		

	}

	@Override
	public List<Movie_Rating> viewRatingHistroyOfOneUser(int id) {
		return movieratingrepo.findByUserId(id);
	
	}

}
