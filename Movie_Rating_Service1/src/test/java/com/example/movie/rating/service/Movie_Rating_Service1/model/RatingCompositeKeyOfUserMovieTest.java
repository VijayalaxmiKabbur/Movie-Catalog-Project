package com.example.movie.rating.service.Movie_Rating_Service1.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RatingCompositeKeyOfUserMovieTest {
	
	
	private RatingCompositeKeyOfUserMovie ob;
	private RatingCompositeKeyOfUserMovie ob1;
	private RatingCompositeKeyOfUserMovie ob2;

	@BeforeEach
	public void setUp() {
		ob = new RatingCompositeKeyOfUserMovie();
		ob1 = new RatingCompositeKeyOfUserMovie(101,1011);
		ob2 = new RatingCompositeKeyOfUserMovie(101,1011);
		
	}

	@Test
	public void test() {
		ob.setMovieId(101);
		ob.setUserId(1011);
		assertEquals("RatingCompositeKeyOfUserMovie [movieId=" + ob.getMovieId() + ", userId=" + ob.getUserId() + "]",ob.toString());
		
	}
	
	@Test
	public void hashCodeEqualsTest() {
		assertEquals(ob1.equals(ob2),ob2.equals(ob1));
		assertEquals(ob1.hashCode(),ob2.hashCode());
	}

}
