package com.example.movie.rating.service.Movie_Rating_Service1.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hamcrest.Matchers;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.movie.rating.service.Movie_Rating_Service1.model.Movie_Rating;
import com.example.movie.rating.service.Movie_Rating_Service1.service.Movie_Rating_Service;


@SpringJUnitConfig
class Movie_Rating_Service_ControllerTest {
	
	
	MockMvc mockMvc;
	
	@Mock
	Movie_Rating_Service movieratingservice;
	
	@InjectMocks
	Movie_Rating_Service_Controller movieratingcontroller;
	
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(movieratingcontroller).build();
	}

	@Test
	public void addRatingToSpecifiedMovieTest() throws Exception {
		
		int movieID = 101;
		int userId = 1011;
		int ratingNo = 10;
		Movie_Rating movie = new Movie_Rating(101,1011,"abc",10);
		when(movieratingservice.addRatingToSpecifiedMovie(movieID, userId, ratingNo)).thenReturn(movie);
		mockMvc.perform(MockMvcRequestBuilders.put("/rating/add/{movieID}/{userId}/{ratingNo}",movieID,userId,ratingNo))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.movieId",Matchers.equalTo(101)));
		
		movieratingcontroller.addRatingToSpecifiedMovie(movieID, userId, ratingNo);
		verify(movieratingservice,times(2)).addRatingToSpecifiedMovie(movieID, userId, ratingNo);
		
		
	}
	
	@Test
	public void viewRatingHistroyOfSpecifiedUserTest() throws Exception {
		int id = 1011;
		List<Movie_Rating> ratings =Stream.of(
				 new Movie_Rating(101,1011,"abc",10),
				 new Movie_Rating(102,1011,"abc",10),
				 new Movie_Rating(103,1011,"abc",10),
				 new Movie_Rating(104,1011,"abc",10)
				).collect(Collectors.toList()); 
	when(movieratingservice.viewRatingHistroyOfOneUser(id)).thenReturn(ratings);
	mockMvc.perform(MockMvcRequestBuilders.get("/rating/viewrating/{id}",id))
	.andExpect(MockMvcResultMatchers.status().isOk())
	.andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(4)))
	.andExpect(MockMvcResultMatchers.jsonPath("$[0].movieId",Matchers.equalTo(101)));
	
	assertEquals(4,movieratingcontroller.viewRatingHistroyOfSpecifiedUser(id).size());
	}

	
}
