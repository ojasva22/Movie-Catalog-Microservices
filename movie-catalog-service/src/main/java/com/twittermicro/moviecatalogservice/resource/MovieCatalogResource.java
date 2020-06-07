package com.twittermicro.moviecatalogservice.resource;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.twittermicro.moviecatalogservice.models.CatalogItem;
import com.twittermicro.moviecatalogservice.models.Movie;
import com.twittermicro.moviecatalogservice.models.Rating;
import com.twittermicro.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder webClientBuilder;
	//get all rated movie id
	//for each movie id call movie info and get details
	//put them all together
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		
		/* RestTemplate restTemplate = new RestTemplate(); */
		
	
		
		UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
		List<Rating> ratings = userRating.getUserRating();
		return ratings.stream().map(rating -> {			
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			/*
			 * Movie movie = webClientBuilder.build() .get()
			 * .uri("http://localhost:9091/movies/"+rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
			
			
			
			
			return new CatalogItem(movie.getMovieName(), "Test" , rating.getRating());
			}).collect(Collectors.toList());
		
		//return Collections.singletonList(new CatalogItem("Transformer", "test", 5));
	}

}
