package com.example.movie.rating.service.Movie_Rating_Service1.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.example.movie.rating.service.Movie_Rating_Service1.daoservice.Movie_Rating_Service_Repository;
import com.example.movie.rating.service.Movie_Rating_Service1.model.Movie_Catalog;
import com.example.movie.rating.service.Movie_Rating_Service1.model.Movie_Rating;


@SpringJUnitConfig
class Movie_Rating_Service_ImpleTest {
	
	@Mock
	Movie_Rating_Service_Repository movieratingrepo;
	
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	Movie_Rating_Service_Imple movieratingservice;
	
	private List<Movie_Catalog> movie_catalog;

	List<Movie_Rating> movies;

	@BeforeEach
	public void setUp() {

              movies = Arrays.asList(
				new Movie_Rating(101,1011,"abc",10),
				new Movie_Rating(102,1011,"def",10),
				new Movie_Rating(103,1011,"ghi",10),
				new Movie_Rating(104,1011,"jkl",10)
				);
      		
	}
	
	
	
	@Test
	void addRatingToSpecifiedMovieTest() {
		
		int movieId = 101;
		int userId = 1011;
		int rating = 10;
		Movie_Rating movierating = new Movie_Rating(101,1011,"abc",10);
		 Movie_Catalog moviecatalog = new Movie_Catalog(101,1011,"abc","It was a awesome movie");
		when(restTemplate.getForObject("http://localhost:8081/movie_catalog/oneHistroy/"+movieId+"/"+userId,Movie_Catalog.class ))
		.thenReturn(moviecatalog);	
		when(movieratingrepo.save(movierating)).thenReturn(movierating);
	    movieratingservice.addRatingToSpecifiedMovie(movieId, userId, rating);
		
		verify(restTemplate).getForObject("http://localhost:8081/movie_catalog/oneHistroy/"+movieId+"/"+userId,Movie_Catalog.class );
		verify(movieratingrepo).save(ArgumentMatchers.refEq(movierating));
	}
	
	@Test
	public void viewRatingHistroyOfOneUserTest() {
		
		int userId = 1011;
		when(movieratingrepo.findByUserId(userId)).thenReturn(movies);
		assertEquals(4,movieratingservice.viewRatingHistroyOfOneUser(userId).size());
		
	}
	
    	
}
