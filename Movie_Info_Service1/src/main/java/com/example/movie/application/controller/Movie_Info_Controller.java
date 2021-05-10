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
	
	
	@GetMapping("/movies")
	public List<Movie_Info> getAllMoviesFromRepository(){
		return movieinfoservice.getAllMovieInfo();
		
	}
	
	@GetMapping("/{id}")
	public Optional<Movie_Info> getSpecifiedMovie(@PathVariable int id){

		return movieinfoservice.getOneMovie(id);
	}
	
	@PostMapping("/addmovie")
	public Movie_Info createMovie(@RequestBody Movie_Info movie) {
		
		return movieinfoservice.postOneMovie(movie);
	}
	
	
	@DeleteMapping("/deletemovie/{id}")
	public Optional<Movie_Info> deleteMovie(@PathVariable("id") int id){
		return movieinfoservice.deleteOneMovie(id);
		
	}
	
	
	

}
