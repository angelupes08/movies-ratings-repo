package com.onito.model;


import java.math.BigDecimal;

import lombok.Data;

@Data
public class AddMoviesDto {
	
	private String tid;
	private String titleType;
	private String primaryTitle;
	private int runtimeMinutes;
	private String genres;
	private java.math.BigDecimal averageRating;
	private int numVotes;
	
	public AddMoviesDto(String tid, String titleType, String primaryTitle, int runtimeMinutes, String genres,
			BigDecimal averageRating, int numVotes) {
		
		this.tid = tid;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
		this.averageRating = averageRating;
		this.numVotes = numVotes;
	}
	
	

}
