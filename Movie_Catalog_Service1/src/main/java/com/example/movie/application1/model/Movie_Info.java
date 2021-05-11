package com.example.movie.application1.model;

public class Movie_Info {
	private int movieId;
	private String movieName;
	private String movieDesc;
	public Movie_Info() {
		super();
	}
	public Movie_Info(int movieId, String movieName, String movieDesc) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDesc() {
		return movieDesc;
	}
	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
	@Override
	public String toString() {
		return "Movie_Info [movieId=" + movieId + ", movieName=" + movieName + ", movieDesc=" + movieDesc + "]";
	}
	

}
