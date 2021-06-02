package com.example.movie.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.application.daoservice.movie_Info_Repository;
import com.example.movie.application.model.Movie_Info;
import com.example.movie.application.service.Movie_Info_Service;

@RestController
@RequestMapping("/movie_info")
public class Movie_Info_Controller {
	
	@Autowired                         
	Movie_Info_Service movieinfoservice;
	
	/**
	 * 
	 * @return all movies stored in the Movie_info_service1 repository
	 */
	@GetMapping("/movies")
	public List<Movie_Info> getAllMoviesFromRepository(){
		return movieinfoservice.getAllMovieInfo();
		//http://localhost:8082/movie_info/movies
	}
	
	@GetMapping("/{id}")
	public Optional<Movie_Info> getSpecifiedMovie(@PathVariable int id){

		return movieinfoservice.getOneMovie(id);
		//http://localhost:8082/movie_info/101
	}
	
	@PostMapping("/addmovie")
	public Movie_Info createMovie(@RequestBody Movie_Info movie) {
		
		return movieinfoservice.postOneMovie(movie);
		//http://localhost:8082/movie_info/addmovie	
	}
	
	
	@DeleteMapping("/deletemovie/{id}")
	public Optional<Movie_Info> deleteMovie(@PathVariable("id") int id){
		return movieinfoservice.deleteOneMovie(id);
		//http://localhost:8082/movie_info/deletemovie/write_ID_Here
		
	}
	
	
	

}
