package com.onito.service;

import java.util.List;


import com.onito.model.Movies;
import com.onito.model.MoviesDto;
import com.onito.model.Ratings;
import com.onito.model.SubtotalsDto;
import com.onito.model.TopRatedMoviesDto;

public interface MoviesService {
	
	public List<MoviesDto> getMovies();
	
	public void addMovies(Movies movie,Ratings rating);
	
	public List<TopRatedMoviesDto> getTopRatedMovies(Double ratings);

	void updateMovieRuntimes();

	public List<Object[]> getGenreMoviesWithSubtotals();
	
	public List<SubtotalsDto> convertToDto(List<Object[]> results);

}
