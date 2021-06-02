package com.example.movie.application1.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.springframework.http.MediaType.*;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.movie.application1.model.Movie_Catalog;
import com.example.movie.application1.model.Movie_Info;
import com.example.movie.application1.service.Movie_Catalog_Service;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringJUnitConfig
class Movie_Catalog_ControllerTest {
	
	private static final int ID = 101;

	private MockMvc mockMvc;
	
	@Mock
	Movie_Catalog_Service moviecatalogservice;
	
	@InjectMocks
	Movie_Catalog_Controller moviecatalogcontroller;

	
	private static ObjectMapper mapper = new ObjectMapper(); 
	//private List<Movie_Info> movies;
	private List<Movie_Catalog> movie_catalog;
	
	private List<Movie_Catalog> movie_catalog_list;
	
	private List<Movie_Info> moviesList;
	
	private Movie_Info movie;
	
	private Movie_Catalog moviecatalog;
	@BeforeEach
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(moviecatalogcontroller).build();
		
		moviesList = Arrays.asList(
				new Movie_Info(100,"GHI","Super"),
				new Movie_Info(101,"IJK","Super"),
				new Movie_Info(102,"ILM","Super"),
				new Movie_Info(104,"GHI","Super")
				);
		
		 movie = new Movie_Info(101,"abc","It was a awesome movie");
		 moviecatalog = new Movie_Catalog(101,1011,"abc","It was a awesome movie");
		
		
		movie_catalog = Arrays.asList(
				new Movie_Catalog(101,1011,"abc","It was a awesome movie"),
				new Movie_Catalog(102,1011,"def","It was a beautiful movie"),
				new Movie_Catalog(103,1011,"ghi","It was a awesome movie"),
				new Movie_Catalog(102,1012,"def","It was a beautiful movie")
				); 
		
		movie_catalog_list = Arrays.asList(
				new Movie_Catalog(101,1011,"abc","It was a awesome movie"),
				new Movie_Catalog(102,1011,"def","It was a beautiful movie"),
				new Movie_Catalog(103,1011,"ghi","It was a awesome movie"),
				new Movie_Catalog(104,1011,"jkl","It was a beautiful movie")
				); 
		
	}
	
	@Test
	public void getAllMoviesTest() throws Exception {
		
		when(moviecatalogservice.getMoviesFromRepository()).thenReturn(moviesList);
		mockMvc.perform(get("/movie_catalog/allmovies"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",Matchers.hasSize(4)))
		.andExpect(jsonPath("$[0].movieId",Matchers.equalTo(100)));
		
	assertEquals(4,moviecatalogcontroller.getAllMovies().size());	

		
		
	}
	
	@Test
	public void getMovie() throws Exception {
		
		when(moviecatalogservice.getOneMovieFromRepository(101)).thenReturn(movie);
		mockMvc.perform(get("/movie_catalog/movie/{id}",ID))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.movieId",Matchers.equalTo(ID)));
		
		assertEquals(movie,moviecatalogcontroller.getMovie(ID));	
		
	}
	
	@Test
	public void addUserTest() throws Exception {
		
		String movievalue = mapper.writeValueAsString(movie);
		
		mockMvc.perform(put("/movie_catalog/movie/{id}/user/{userId}/opinion/{opinion}",101,1011,"It was a awesome movie")
				.contentType(APPLICATION_JSON)
				.content(movievalue)
				.accept(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
				//.andExpect(jsonPath("$.movieId",Matchers.equalTo(ID)));
		
				moviecatalogcontroller.addUser(ID, 1011,"It was a awesome movie");
				verify(moviecatalogservice,times(2)).addUser(ID,1011, "It was a awesome movie");
	}
	
	@Test
	public void viewWatchHistroyOfOneUserByIdTest() throws Exception {
		
		int id = 1011;
		when( moviecatalogservice.viewWatchHistroyOfOneUser(id)).thenReturn(movie_catalog_list);
		mockMvc.perform(get("/movie_catalog/watchhistroy/{id}",1011))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",Matchers.hasSize(4)))
		.andExpect(jsonPath("$[0].movieId",Matchers.equalTo(ID)));
		
		assertEquals(4,moviecatalogcontroller.viewWatchHistroyOfOneUserById(id).size());
		
	}
	
	@Test
	public void histroyOfOneMovieCompositeKeyByBothIdsTest() throws Exception {
		int movieId= 101;
		int userId = 1011;
		when(moviecatalogservice.histroyOfOneMovieCompositeKey(movieId, userId)).thenReturn( moviecatalog);
		mockMvc.perform(get("/movie_catalog/oneHistroy/{movieId}/{userId}",101,1011))
	           .andExpect(status().isOk())
	           .andExpect(jsonPath("$.movieId",Matchers.equalTo(movieId)));
		
		assertEquals(moviecatalog,moviecatalogcontroller.histroyOfOneMovieCompositeKeyByBothIds(movieId, userId));
		
	}
	

}
