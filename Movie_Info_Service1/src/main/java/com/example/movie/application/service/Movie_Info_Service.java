package com.example.movie.application.service;

import java.util.List;
import java.util.Optional;

import com.example.movie.application.model.Movie_Info;

public interface Movie_Info_Service {
	public List<Movie_Info> getAllMovieInfo();
	
	public Optional<Movie_Info> getOneMovie(int id);
	
	public Movie_Info postOneMovie(Movie_Info movie);
	
	public Optional<Movie_Info> deleteOneMovie(int id);
	
	

}
