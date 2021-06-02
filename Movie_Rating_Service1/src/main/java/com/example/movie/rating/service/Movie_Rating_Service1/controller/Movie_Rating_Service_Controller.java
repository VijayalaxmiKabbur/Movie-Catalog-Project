package com.example.movie.rating.service.Movie_Rating_Service1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.rating.service.Movie_Rating_Service1.model.Movie_Rating;
import com.example.movie.rating.service.Movie_Rating_Service1.service.Movie_Rating_Service;

@RestController
@RequestMapping("/rating")
public class Movie_Rating_Service_Controller {
	
	@Autowired
	Movie_Rating_Service movieratingservice;
	
	/**
	 * If user wants to update his/her rating for the particular movie in that case user needs
	 * to provide the below details 
	 * @param movieID
	 * @param userId
	 * @param ratingNo
	 * @return the updated movie rating for the specific user.
	 */
	@PutMapping("/add/{movieID}/{userId}/{ratingNo}")
	public Movie_Rating addRatingToSpecifiedMovie(@PathVariable("movieID")int movieID,@PathVariable("userId")int userId, @PathVariable("ratingNo")int ratingNo) {
		return movieratingservice.addRatingToSpecifiedMovie(movieID, userId, ratingNo);
		//http://localhost:8083/rating/add/101/1011/10
		
	}
	/**
	 * to view the rating history of specific user
	 * @param id
	 * @return the rating history of specific user
	 */
	@GetMapping("/viewrating/{id}")
	public List<Movie_Rating> viewRatingHistroyOfSpecifiedUser(@PathVariable("id") int id){
		return movieratingservice.viewRatingHistroyOfOneUser(id);
		
		//http://localhost:8083/rating/viewrating/1011
		
	}

}
