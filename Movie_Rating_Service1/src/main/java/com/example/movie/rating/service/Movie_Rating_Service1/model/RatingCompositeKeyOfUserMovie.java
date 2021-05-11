package com.example.movie.rating.service.Movie_Rating_Service1.model;

import java.io.Serializable;

public class RatingCompositeKeyOfUserMovie implements Serializable {
	private int movieId;
	private int userId;
	public RatingCompositeKeyOfUserMovie() {
		super();
	}
	public RatingCompositeKeyOfUserMovie(int movieId, int userId) {
		super();
		this.movieId = movieId;
		this.userId = userId;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movieId;
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatingCompositeKeyOfUserMovie other = (RatingCompositeKeyOfUserMovie) obj;
		if (movieId != other.movieId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RatingCompositeKeyOfUserMovie [movieId=" + movieId + ", userId=" + userId + "]";
	}
	
	
	

}
