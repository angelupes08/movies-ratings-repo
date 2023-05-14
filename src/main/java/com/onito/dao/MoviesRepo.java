package com.onito.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.onito.model.Movies;
import com.onito.model.MoviesDto;
import com.onito.model.SubtotalsDto;
import com.onito.model.TopRatedMoviesDto;

public interface MoviesRepo extends JpaRepository<Movies, String>{
	

	
	 @Query("SELECT new com.onito.model.MoviesDto(m.tid, m.primaryTitle,m.runtimeMinutes,m.genres) FROM Movies m ORDER BY m.runtimeMinutes DESC")
	 List<MoviesDto> findTop10ColumnsOnlyOrderByRuntimeMinutesDesc();
	 
	 @Query("SELECT new com.onito.model.TopRatedMoviesDto(m.tid, m.primaryTitle,r.averageRating,m.genres)FROM Movies m INNER JOIN m.ratings r"
	 		+ " WHERE r.averageRating> ?1")
	 List<TopRatedMoviesDto> findByAverageRatingGreaterThan(Double rating);
	 
	 @Modifying
	 @Query("UPDATE Movies m SET m.runtimeMinutes = "
	            + "CASE "
	            + "WHEN m.genres = 'Documentary' THEN m.runtimeMinutes + 15 "
	            + "WHEN m.genres = 'Animation' THEN m.runtimeMinutes + 30 "
	            + "ELSE m.runtimeMinutes + 45 "
	            + "END")
	  void updateRuntimeMinutes();
	 
	 @Query("SELECT m.genres, m.primaryTitle, SUM(r.numVotes) " +
	            "FROM Movies m " +
	            "JOIN m.ratings r " +
	            "GROUP BY m.genres, m.primaryTitle " +
	            "ORDER BY m.genres ASC, m.primaryTitle ASC")
	 List<Object[]> findGenresMoviesWithSubtotals();
	
	
	
	
	
	
	

}
