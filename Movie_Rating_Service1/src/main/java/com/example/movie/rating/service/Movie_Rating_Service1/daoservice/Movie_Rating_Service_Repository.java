package com.example.movie.rating.service.Movie_Rating_Service1.daoservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.rating.service.Movie_Rating_Service1.model.Movie_Rating;
import com.example.movie.rating.service.Movie_Rating_Service1.model.RatingCompositeKeyOfUserMovie;

@Repository
public interface Movie_Rating_Service_Repository extends JpaRepository<Movie_Rating, RatingCompositeKeyOfUserMovie>{
	List<Movie_Rating> findByUserId(int id);

}
