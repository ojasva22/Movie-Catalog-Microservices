package com.twittermicro.movieinfoservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twittermicro.movieinfoservice.models.Movie;


@RestController
@RequestMapping("/movies")
public class MovieInfo {
	 @RequestMapping("/{movieId}")
	    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
	        return new Movie(movieId, "Transformers");
}
}
