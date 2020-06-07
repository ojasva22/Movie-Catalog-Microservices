package com.twittermicro.movieinfoservice.models;

public class Movie {
	
	private String movieId;
	private String movieName;

	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public Movie(String movieId2, String movieName) {
		super();
		this.movieId = movieId2;
		this.movieName = movieName;
		
	}
	
	
}
