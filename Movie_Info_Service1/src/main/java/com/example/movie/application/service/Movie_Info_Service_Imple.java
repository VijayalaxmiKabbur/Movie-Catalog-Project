package com.example.movie.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie.application.daoservice.movie_Info_Repository;
import com.example.movie.application.model.Movie_Info;

@Service
public class Movie_Info_Service_Imple implements Movie_Info_Service{

	
	@Autowired
	movie_Info_Repository movierepo;
	@Override
	public List<Movie_Info> getAllMovieInfo() {
		return movierepo.findAll();	
	}

	@Override
	public Optional<Movie_Info> getOneMovie(int id) {
		return movierepo.findById(id);
		
	}

	@Override
	public Movie_Info postOneMovie(Movie_Info movie) {
		return movierepo.save(movie);
		
	}

	@Override
	public Optional<Movie_Info> deleteOneMovie(int id) {
		Optional<Movie_Info> movie = movierepo.findById(id);
		movierepo.deleteById(id);
		return movie;
	}

	

	
	
	

}
