package com.example.movie.application.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.application.model.Movie_Info;

@Repository
public interface movie_Info_Repository extends JpaRepository<Movie_Info,Integer> {

}
