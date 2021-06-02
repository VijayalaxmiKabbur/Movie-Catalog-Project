package com.example.movie.rating.service.Movie_Rating_Service1.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Movie_RatingTest {
	
	Movie_Rating ob = new Movie_Rating();

	@Test
	void test() {
		ob.setMovieId(101);
		ob.setUserId(1011);
		ob.setMovieName("abc");
		ob.setRating(10);
		assertEquals("Movie_Rating [movieId=" + ob.getMovieId() + ", userId=" + ob.getUserId() + ", movieName=" + ob.getMovieName() + ", rating="
				+ ob.getRating() + "]",ob.toString());
	}

}
