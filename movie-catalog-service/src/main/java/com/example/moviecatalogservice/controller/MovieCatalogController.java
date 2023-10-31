package com.example.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.model.Catalog;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public List<Catalog> getCatalog(@PathVariable("userId") String userId) {
		
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingdata/users/" + userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/info/" + rating.getMovieId(), Movie.class);
			return new Catalog(movie.getName(), "Movie about huge alien bots that are infamous for battles", rating.getRating());
		})
		.collect(Collectors.toList());
	}
	
	@PostMapping("/addmoviedata")
	public ResponseEntity<Catalog> addMovieData(@RequestBody Catalog catalog) {
		return new ResponseEntity<>(catalog, HttpStatus.CREATED);
	}
	
	public String getMovieRating() {
		return "";
	}
	
}
