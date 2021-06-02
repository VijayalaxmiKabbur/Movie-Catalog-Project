package com.example.movie.rating.service.Movie_Rating_Service1.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Movie_CatalogTest {

	Movie_Catalog ob = new Movie_Catalog();
	
	@Test
	void test() {
	ob.setMovieId(101);
	ob.setUserId(1011);
	ob.setMovieName("abc");
	ob.setOpinion("It was a awesome movie");
	
	assertEquals("Movie_Catalog [movieId=" + ob.getMovieId() + ", userId=" + ob.getUserId() + ", movieName=" + ob.getMovieName() + ", opinion="
				+ ob.getOpinion() + "]",ob.toString());
	}

}
