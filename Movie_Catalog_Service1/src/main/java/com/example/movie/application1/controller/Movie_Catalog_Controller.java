package com.example.movie.application1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	/**
	 * 
	 * @return the all movies Information from the Movie_Info_Service1
	 */
	@GetMapping("/allmovies")
	public List getAllMovies() {
		return moviecatalogservice.getMoviesFromRepository();
		
		//http://localhost:8081/movie_catalog/allmovies
		
	}
	/**
	 * 
	 * @param id : we need to give movie_id to get information about the movie.
	 * @return the specified movie information
	 */
	
	@GetMapping("/movie/{id}")
	public Movie_Info getMovie(@PathVariable("id") int id) {
		return moviecatalogservice.getOneMovieFromRepository(id);
		//http://localhost:8081/movie_catalog/movie/101
		
	}
	
	/**
	 * Sometimes user wants the change the opinion for the particular movie so in that case
	 * user needs to give movie_id, user_id and opinion to update the changes in the Movie_Catalog_Service1.
	 * @param id
	 * @param userId
	 * @param opinion
	 */
	@PutMapping("/movie/{id}/user/{userId}/opinion/{opinion}")
	public void addUser(@PathVariable("id") int id,@PathVariable("userId") int userId,@PathVariable("opinion") String opinion) {
		moviecatalogservice.addUser(id, userId, opinion);
		
		//http://localhost:8081/movie_catalog/movie/101/user/1011/opinion/soooper
	}
	
	/**
	 * 
	 * @param id : we need to pass the User_id 
	 * @return the Watch History of specific User 
	 */
	@GetMapping("/watchhistroy/{id}")
	public List<Movie_Catalog> viewWatchHistroyOfOneUserById(@PathVariable("id") int id){
		return moviecatalogservice.viewWatchHistroyOfOneUser(id);
		
		//http://localhost:8081/movie_catalog/watchhistroy/1011
		
	}
	
	/**
	 * 
	 * @param movieId
	 * @param userId
	 * @return the Watch History of specific User of specific movie
	 */
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
