package com.example.movie.application1.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserIdMovieIdCompositeKeyTest {

	
	private UserIdMovieIdCompositeKey ob;
	private UserIdMovieIdCompositeKey ob1;
	private UserIdMovieIdCompositeKey ob2;

	@BeforeEach
	public void setUp() {
		ob = new UserIdMovieIdCompositeKey();
		ob1 = new UserIdMovieIdCompositeKey(101,1011);
		ob2 = new UserIdMovieIdCompositeKey(101,1011);
		
	}
	@Test
	void test() {
		
		ob.setMovieId(101);
		ob.setUserId(1011);
		assertEquals("UserIdMovieIdCompositeKey [movieId=" + ob.getMovieId() + ", userId=" + ob.getUserId() + "]",ob.toString());
	}
	
	/**
	 * hashCode() returns an integer representing the current instance of the class.
	 *  We should calculate this value consistent with the definition of equality for the class. 
	 * Thus if we override the equals() method, we also have to override hashCode().
	 * 
	 * internal consistency: the value of hashCode() may only change 
	 * if a property that is in equals() changes
      equals consistency: objects that are equal to each other must return the same hashCode
      collisions: unequal objects may have the same hashCode
	 */
	
	@Test
	public void hashCodeTest() {
		
		assertEquals(ob1.equals(ob2),ob2.equals(ob1));
		assertEquals(ob1.hashCode(),ob2.hashCode());
	}
	
	@Test
	public void equalsTest() {
		
	}
	

}
