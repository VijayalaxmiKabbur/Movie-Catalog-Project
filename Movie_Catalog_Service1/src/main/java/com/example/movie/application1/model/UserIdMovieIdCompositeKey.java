package com.example.movie.application1.model;

import java.io.Serializable;



public class UserIdMovieIdCompositeKey implements Serializable {

	private int movieId;
	private int userId;
	
	public UserIdMovieIdCompositeKey() {
		super();
	}

	public UserIdMovieIdCompositeKey(int movieId, int userId) {
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
		UserIdMovieIdCompositeKey other = (UserIdMovieIdCompositeKey) obj;
		if (movieId != other.movieId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserIdMovieIdCompositeKey [movieId=" + movieId + ", userId=" + userId + "]";
	}
	
	
	
	
}
