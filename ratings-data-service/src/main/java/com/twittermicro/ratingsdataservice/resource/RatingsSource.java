package com.twittermicro.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twittermicro.ratingsdataservice.model.Rating;
import com.twittermicro.ratingsdataservice.model.UserRating;


@RestController
@RequestMapping("/ratingsdata")
public class RatingsSource {


	@RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);  
    }
	
	@GetMapping("/users/{userId}")
	public UserRating getRatings(@PathVariable("userId") String userId) {
		return new UserRating(Arrays.asList(new Rating("1234", 4), new Rating("5678", 5)));
				
	}
}
