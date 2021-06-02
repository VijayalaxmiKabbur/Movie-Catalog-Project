package com.example.movie.rating.service.Movie_Rating_Service1.service;

import java.util.List;

import com.example.movie.rating.service.Movie_Rating_Service1.model.Movie_Rating;

public interface Movie_Rating_Service {
	public Movie_Rating addRatingToSpecifiedMovie(int movieId,int userId,int ratingNo);
	
	public List<Movie_Rating> viewRatingHistroyOfOneUser(int id);

}
