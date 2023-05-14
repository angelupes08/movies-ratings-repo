package com.onito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onito.dao.MoviesRepo;
import com.onito.dao.RatingsRepo;
import com.onito.model.Movies;
import com.onito.model.MoviesDto;
import com.onito.model.Ratings;
import com.onito.model.SubtotalsDto;
import com.onito.model.TopRatedMoviesDto;

import jakarta.transaction.Transactional;


@Service
public class MoviesServiceImpl implements MoviesService {
	
	@Autowired
	private MoviesRepo mRepo;
	
	@Autowired
	private RatingsRepo rRepo;
	
	@Override
	public List<MoviesDto> getMovies(){
		return mRepo.findTop10ColumnsOnlyOrderByRuntimeMinutesDesc();
		
	}

	@Override
	public void addMovies(Movies movie,Ratings rating) {
		
		movie.setRatings(rating);
		rating.setMovies(movie);
		mRepo.save(movie);
		
		
	}

	@Override
	public List<TopRatedMoviesDto> getTopRatedMovies(Double ratings) {
		
		return mRepo.findByAverageRatingGreaterThan(ratings);
	}
	
	@Override
	@Transactional
	    public void updateMovieRuntimes() {
	        mRepo.updateRuntimeMinutes();
	    }

	@Override
	public List<Object[]> getGenreMoviesWithSubtotals() {
		
		return mRepo.findGenresMoviesWithSubtotals();
	}
	
	@Override
	public List<SubtotalsDto> convertToDto(List<Object[]> results) {
	        List<SubtotalsDto> dtos = new ArrayList<>();
	        for (Object[] result : results) {
	            SubtotalsDto dto = new SubtotalsDto();
	            dto.setGenres((String) result[0]);
	            dto.setPrimaryTitle((String) result[1]);
	            dto.setNumVotes(((Number) result[2]).intValue());
	            dtos.add(dto);
	        }
	        return dtos;
	    }
	

}
