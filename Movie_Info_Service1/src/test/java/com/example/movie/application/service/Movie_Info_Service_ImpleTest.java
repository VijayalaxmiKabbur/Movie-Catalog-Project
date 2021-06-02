package com.example.movie.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.movie.application.daoservice.movie_Info_Repository;
import com.example.movie.application.model.Movie_Info;

@SpringJUnitConfig
class Movie_Info_Service_ImpleTest {
	
	@Mock
	movie_Info_Repository movierepo;
	
	@InjectMocks
	Movie_Info_Service_Imple movieinfo;

	//private List<Movie_Info> movies;

	private List<Movie_Info> moviesList;
	
	@BeforeEach
	public void setUp() {
		//movies = Stream.of(new Movie_Info(101,"This movie contains lot of emotional scenes","abc")).collect(Collectors.toList());
		
		moviesList = Arrays.asList(
				new Movie_Info(100,"GHI","Super"),
				new Movie_Info(101,"IJK","Super"),
				new Movie_Info(102,"ILM","Super"),
				new Movie_Info(104,"GHI","Super")
				);
		
	}

	@Test
	void getAllMovieInfoTest() {
		when(movierepo.findAll()).thenReturn(moviesList);
		assertEquals(4,movieinfo.getAllMovieInfo().size());
		
		

	}
	
	@Test
	void getOneMovieTest() {
		int id = 100;
		Optional<Movie_Info> movie = Optional.ofNullable(new Movie_Info(100,"GHI","Super"));
		when(movierepo.findById(id)).thenReturn(movie);
		assertEquals(movie,movieinfo.getOneMovie(id));
		
	}
	
	@Test
	void  postOneMovieTest() {
		Movie_Info movie = new Movie_Info(100,"GHI","Super");
		when(movierepo.save(movie)).thenReturn(movie);
		assertEquals(movie,movieinfo.postOneMovie(movie));
		verify(movierepo).save(movie);
	}
	
	@Test
	void deleteOneMovieTest() {
		int id = 100;
		Optional<Movie_Info> movie = Optional.ofNullable(new Movie_Info(100,"GHI","Super"));
		when(movierepo.findById(id)).thenReturn(movie);
		assertEquals(movie,movieinfo.deleteOneMovie(id));
		verify(movierepo).deleteById(id);
		
	}
	
	
	

}

