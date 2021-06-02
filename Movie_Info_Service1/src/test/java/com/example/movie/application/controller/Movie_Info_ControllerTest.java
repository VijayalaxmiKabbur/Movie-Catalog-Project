package com.example.movie.application.controller;
/**
 * The "webAppContextSetup" loads the actual Spring MVC configuration resulting 
 * in a more complete integration test. Since the TestContext framework caches 
 * the loaded Spring configuration, it helps to keep tests running fast even as more
 * tests get added. Furthermore, you can inject mock services into controllers 
 * through Spring configuration, in order to remain focused on testing the web layer.
 */

/**
 * The "standaloneSetup" on the other hand is a little closer to a unit test. 
 * It tests one controller at a time, the controller can be injected with mock dependencies
 *  manually, and it doesn’t involve loading Spring configuration. Such tests are more 
 *  focused in style and make it easier to see which controller is being tested, 
 *  whether any specific Spring MVC configuration is required to work, and so on.
 *   The "standaloneSetup" is also a very convenient
 *  way to write ad-hoc tests to verify some behavior or to debug an issue.
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.movie.application.model.Movie_Info;
import com.example.movie.application.service.Movie_Info_Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringJUnitConfig
class Movie_Info_ControllerTest {
	
	private MockMvc mockMvc;
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Mock
	Movie_Info_Service movieinfoservice;
	
	@InjectMocks
	Movie_Info_Controller movieinfocontl;
	
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
			
			mockMvc = MockMvcBuilders.standaloneSetup(movieinfocontl).build();
			
		}

	@Test
	void getAllMoviesFromRepositoryTest() throws Exception {
		when(movieinfoservice.getAllMovieInfo()).thenReturn(moviesList);
		mockMvc.perform(MockMvcRequestBuilders.get("/movie_info/movies"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(4)))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].movieId",Matchers.equalTo(100)));
		
		assertEquals(4,movieinfocontl.getAllMoviesFromRepository().size());
		verify(movieinfoservice,times(2)).getAllMovieInfo();
		
	}
	
	
	@Test
	void getSpecifiedMovieTest() throws Exception {
		int id = 100;

		Optional<Movie_Info> movie = Optional.ofNullable(new Movie_Info(100,"GHI","Super"));
		when(movieinfoservice.getOneMovie(id)).thenReturn(movie);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/movie_info/{id}",100))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.movieId",Matchers.equalTo(100)));
		assertEquals(movie,movieinfocontl.getSpecifiedMovie(id));
		verify(movieinfoservice,times(2)).getOneMovie(id);
		
	}

	@Test
	void createMovieTest() throws Exception {
		Movie_Info movie = new Movie_Info(100,"GHI","Super");
		String value = mapper.writeValueAsString(movie);
		when(movieinfoservice.postOneMovie(movie)).thenReturn(movie);
		mockMvc.perform(MockMvcRequestBuilders.post("/movie_info/addmovie")
				.contentType(MediaType.APPLICATION_JSON)
				.content(value).accept(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        //.andExpect(MockMvcResultMatchers.jsonPath("$.movieId",Matchers.equalTo(100)))
		        .andReturn().getResponse().getContentAsString();
		

		assertEquals(movie,movieinfocontl.createMovie(movie));
		verify(movieinfoservice).postOneMovie(movie);
	}
	
	@Test
	void deleteMovieTest() throws Exception {
		int id = 100;
		Optional<Movie_Info> movie = Optional.ofNullable(new Movie_Info(100,"GHI","Super"));
		when(movieinfoservice.deleteOneMovie(id)).thenReturn(movie);
		mockMvc.perform(MockMvcRequestBuilders.delete("/movie_info/deletemovie/{id}",100))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.movieId",Matchers.equalTo(100)));
		
		
		assertEquals(movie,movieinfocontl.deleteMovie(id));
		
	}
}
