package com.example.movie.application1.service;
import java.util.*;

import com.example.movie.application1.model.Movie_Catalog;
import com.example.movie.application1.model.Movie_Info;
public interface Movie_Catalog_Service {
	
	public List getMoviesFromRepository();
	
	public Movie_Info getOneMovieFromRepository(int id);
	
	public void addUser(int id,int userId,String opinion);
	
	public List<Movie_Catalog> viewWatchHistroyOfOneUser(int id);
	
	public Movie_Catalog histroyOfOneMovieCompositeKey(int movieId,int userId);
	
	//public Movie_Catalog deleteOneHistroy(int movieId,int userId);

}
