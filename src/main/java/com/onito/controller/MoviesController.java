package com.onito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onito.model.AddMoviesDto;
import com.onito.model.Movies;
import com.onito.model.MoviesDto;
import com.onito.model.Ratings;
import com.onito.model.SubtotalsDto;
import com.onito.model.TopRatedMoviesDto;
import com.onito.service.MoviesService;

import jakarta.websocket.server.PathParam;

@RestController
public class MoviesController {
	
	@Autowired
	private MoviesService mService;
	
	@GetMapping("/longest-duration-movies")
	public List<MoviesDto> getMovies(){
		return mService.getMovies();
		
	}
	@PostMapping("/new-movie")
	public String addMovies(@RequestBody AddMoviesDto addmovie) {
		
		Movies movies = new Movies();
		
		movies.setTid(addmovie.getTid());
		movies.setPrimaryTitle(addmovie.getPrimaryTitle());
		movies.setTitleType(addmovie.getTitleType());
		movies.setGenres(addmovie.getGenres());
		movies.setRuntimeMinutes(addmovie.getRuntimeMinutes());
		
		
		Ratings ratings = new Ratings();
		
		ratings.setTid(addmovie.getTid());
		ratings.setAverageRating(addmovie.getAverageRating());
		ratings.setNumVotes(addmovie.getNumVotes());

		
		mService.addMovies(movies,ratings);
		
		return "success";
		
	}
	
	@GetMapping("/top-rated-movies")
	public List<TopRatedMoviesDto> getTopRatedMovies(@PathParam("rate")Double rate){
		
		return mService.getTopRatedMovies(rate);
	}
	
	@GetMapping("/genre-movies-with-subtotals")
	public List<SubtotalsDto> getGenreMoviesWithSubtotals(){
		List<Object[]> results = mService.getGenreMoviesWithSubtotals();
		return mService.convertToDto(results);
	}
	
	@PostMapping("/update-runtime-minutes")
    public String updateMovieRuntimes() {
        mService.updateMovieRuntimes();
        return "Movie runtimes has been updated successfully";
    }

}
