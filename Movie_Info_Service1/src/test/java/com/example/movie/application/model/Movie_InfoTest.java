package com.example.movie.application.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class Movie_InfoTest {
	
	Movie_Info movieinfo = new Movie_Info();

	@Test
	void test() {
		movieinfo.setMovieId(100);
		movieinfo.setMovieName("GHI");
		movieinfo.setMovieDesc("Super");
		movieinfo.toString();

		assertEquals("Movie_Info [movieId=" + movieinfo.getMovieId() + ", movieName=" + movieinfo.getMovieName() + ", movieDesc=" + movieinfo.getMovieDesc() + "]",movieinfo.toString());
	}

}
