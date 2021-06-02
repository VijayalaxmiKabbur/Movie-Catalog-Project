package com.example.movie.application1.daoservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.application1.model.Movie_Catalog;
import com.example.movie.application1.model.UserIdMovieIdCompositeKey;

@Repository
public interface Movie_Catalog_Repository extends JpaRepository<Movie_Catalog,UserIdMovieIdCompositeKey> {

	List<Movie_Catalog> findByuserId(int id);
	Movie_Catalog findByMovieIdAndUserId(int movieId, int userId);
	//Movie_Catalog deleteByMovieIdAndUserId(int movieId, int userId);
	

}
