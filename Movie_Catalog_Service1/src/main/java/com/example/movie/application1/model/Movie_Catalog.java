package com.example.movie.application1.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(UserIdMovieIdCompositeKey.class)
public class Movie_Catalog {
	
	@Id
	private int movieId;
	@Id
	private int userId;
	
	private String movieName;
	private String opinion;
	
	public Movie_Catalog() {
		super();
	}

	public Movie_Catalog(int movieId, int userId, String movieName, String opinion) {
		super();
		this.movieId = movieId;
		this.userId = userId;
		this.movieName = movieName;
		this.opinion = opinion;
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

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	@Override
	public String toString() {
		return "Movie_Catalog [movieId=" + movieId + ", userId=" + userId + ", movieName=" + movieName + ", opinion="
				+ opinion + "]";
	}

	
    

}
