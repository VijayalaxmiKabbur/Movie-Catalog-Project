package com.example.movie.application1.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;
import com.example.movie.application1.daoservice.Movie_Catalog_Repository;
import com.example.movie.application1.model.*;


@SpringJUnitConfig
class Movie_Catalog_Service_ImpleTest {
	
	@Mock
	Movie_Catalog_Repository catalogrepo;
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	Movie_Catalog_Service_Imple movieCatalogService;
	
	//private List<Movie_Info> movies;
	private List<Movie_Catalog> movie_catalog;
	
	private List<Movie_Catalog> movie_catalog_list;
	
	private List<Movie_Info> moviesList;
	
	private Movie_Info movie;
	
	private Movie_Catalog moviecatalog;

	int id = 101;
	
	@BeforeEach
	public void setUp() {
		
		 movie = new Movie_Info(101,"abc","Super");
		 moviecatalog = new Movie_Catalog(101,1011,"abc","It was a awesome movie");
		
		
		movie_catalog = Arrays.asList(
				new Movie_Catalog(101,1011,"abc","It was a awesome movie"),
				new Movie_Catalog(102,1011,"def","It was a beautiful movie"),
				new Movie_Catalog(103,1011,"ghi","It was a awesome movie"),
				new Movie_Catalog(102,1012,"def","It was a beautiful movie")
				); 
		
		moviesList = Arrays.asList(
				new Movie_Info(100,"GHI","Super"),
				new Movie_Info(101,"abc","Super"),
				new Movie_Info(102,"ILM","Super"),
				new Movie_Info(104,"GHI","Super")
				);
		
		movie_catalog_list = Arrays.asList(
				new Movie_Catalog(101,1011,"abc","It was a awesome movie"),
				new Movie_Catalog(101,1011,"def","It was a beautiful movie"),
				new Movie_Catalog(101,1011,"ghi","It was a awesome movie"),
				new Movie_Catalog(101,1012,"def","It was a beautiful movie")
				); 
		
	}

	@Test
	void getMoviesFromRepositoryTest() {
		when(restTemplate.getForObject("http://localhost:8082/movie_info/movies",List.class))
		.thenReturn(moviesList);
		assertEquals(4,movieCatalogService.getMoviesFromRepository().size());
		verify(restTemplate).getForObject("http://localhost:8082/movie_info/movies",List.class);
	}
	
	
	@Test
	void getOneMovieFromRepositoryTest() {

		when(restTemplate.getForObject("http://localhost:8082/movie_info/"+id,Movie_Info.class))
		.thenReturn(movie);
		assertEquals(movie,movieCatalogService.getOneMovieFromRepository(id));
		verify(restTemplate).getForObject("http://localhost:8082/movie_info/"+id,Movie_Info.class);
	}
	
	@Test
	public void addUserTest() {
		when(restTemplate.getForObject("http://localhost:8082/movie_info/"+id,Movie_Info.class))
		.thenReturn(movie);
		
		assertEquals(movie,movieCatalogService.getOneMovieFromRepository(id));
		verify(restTemplate).getForObject("http://localhost:8082/movie_info/"+id,Movie_Info.class);
		
		 movieCatalogService.addUser(101,1011,"It was a awesome movie");
		
	}
	
	@Test
	public void viewWatchHistroyOfOneUserTest() {
		when(catalogrepo.findByuserId(id)).thenReturn(movie_catalog_list);
		assertEquals(4,movieCatalogService.viewWatchHistroyOfOneUser(id).size());
		verify(catalogrepo).findByuserId(id);
		
	}
	
	@Test
	public void histroyOfOneMovieCompositeKeyTest() {
		int movieId = 101;
		int userId = 1011;
		when(catalogrepo.findByMovieIdAndUserId(movieId, userId)).thenReturn(moviecatalog);
		assertEquals(moviecatalog,movieCatalogService.histroyOfOneMovieCompositeKey(movieId, userId));
		verify(catalogrepo).findByMovieIdAndUserId(movieId, userId);
	}
	

}
