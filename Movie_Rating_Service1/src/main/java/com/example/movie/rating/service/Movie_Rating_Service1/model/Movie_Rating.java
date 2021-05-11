package com.example.movie.rating.service.Movie_Rating_Service1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(RatingCompositeKeyOfUserMovie.class)
public class Movie_Rating {
	@Id
	private int movieId;
	@Id
	private int userId;
	private String movieName;
	private int rating;
	public Movie_Rating() {
		super();
	}
	public Movie_Rating(int movieId, int userId, String movieName, int rating) {
		super();
		this.movieId = movieId;
		this.userId = userId;
		this.movieName = movieName;
		this.rating = rating;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie_Rating [movieId=" + movieId + ", userId=" + userId + ", movieName=" + movieName + ", rating="
				+ rating + "]";
	}
	
	

}
