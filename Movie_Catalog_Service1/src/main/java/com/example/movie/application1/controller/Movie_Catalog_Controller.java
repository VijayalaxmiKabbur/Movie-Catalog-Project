package com.example.movie.application1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.application1.model.Movie_Catalog;
import com.example.movie.application1.model.Movie_Info;
import com.example.movie.application1.service.Movie_Catalog_Service;


@RestController
@RequestMapping("/movie_catalog")
public class Movie_Catalog_Controller {
	
	@Autowired
	Movie_Catalog_Service moviecatalogservice;
	
	@GetMapping("/allmovies")
	public List getAllMovies() {
		return moviecatalogservice.getMoviesFromRepository();
		
	}
	
	@GetMapping("/movie/{id}")
	public Movie_Info getMovie(@PathVariable("id") int id) {
		return moviecatalogservice.getOneMovieFromRepository(id);
		
	}
	
	@PostMapping("/movie/{id}/user/{userId}/opinion/{opinion}")
	public void addUser(@PathVariable("id") int id,@PathVariable("userId") int userId,@PathVariable("opinion") String opinion) {
		moviecatalogservice.addUser(id, userId, opinion);
	}
	
	@GetMapping("/watchhistroy/{id}")
	public List<Movie_Catalog> viewWatchHistroyOfOneUserById(@PathVariable("id") int id){
		return moviecatalogservice.viewWatchHistroyOfOneUser(id);
		
	}
	
	@GetMapping("/oneHistroy/{movieId}/{userId}")
	public Movie_Catalog histroyOfOneMovieCompositeKeyByBothIds(@PathVariable("movieId")int movieId,@PathVariable("userId") int userId) {
		return moviecatalogservice.histroyOfOneMovieCompositeKey(movieId, userId);
		//http://localhost:8081/movie_catalog/oneHistroy/102/1012
	}
	
	
//	@DeleteMapping("/delete/oneHistroy/{movieId}/{userId}")
//	public Movie_Catalog deleteOneHistroyOfOneUser(int movieId, int userId) {
//		return moviecatalogservice.deleteOneHistroy(movieId, userId);
//		
//	}
	

	
}
