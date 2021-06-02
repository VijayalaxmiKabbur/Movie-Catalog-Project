package com.example.movie.application1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.movie.application1.daoservice.Movie_Catalog_Repository;
import com.example.movie.application1.model.Movie_Catalog;
import com.example.movie.application1.model.Movie_Info;

@Service
public class Movie_Catalog_Service_Imple implements Movie_Catalog_Service {
	@Autowired
	Movie_Catalog_Repository catalogrepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List getMoviesFromRepository() {
		return restTemplate.getForObject("http://localhost:8082/movie_info/movies",List.class);
		
	}

	@Override
	public Movie_Info getOneMovieFromRepository(int id) {
		return restTemplate.getForObject("http://localhost:8082/movie_info/"+id,Movie_Info.class);
	}

	@Override
	public void addUser(int id, int userId, String opinion) {
		Movie_Info movieinfo = restTemplate.getForObject("http://localhost:8082/movie_info/"+id,Movie_Info.class);
		Movie_Catalog moviecatalog = new Movie_Catalog(id,userId,movieinfo.getMovieName(),opinion);
		catalogrepo.save(moviecatalog);
	}

	@Override
	public List<Movie_Catalog> viewWatchHistroyOfOneUser(int id) {
		return catalogrepo.findByuserId(id);	
		
	}

	@Override
	public Movie_Catalog histroyOfOneMovieCompositeKey(int movieId, int userId) {
		return catalogrepo.findByMovieIdAndUserId(movieId, userId);
		
	}

//	@Override
//	public Movie_Catalog deleteOneHistroy(int movieId, int userId) {
//		return catalogrepo.deleteByMovieIdAndUserId(movieId, userId);
//		
//	}

}
