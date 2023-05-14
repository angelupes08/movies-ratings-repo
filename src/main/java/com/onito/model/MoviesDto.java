package com.onito.model;

import lombok.Data;



@Data
public class MoviesDto {
	
	 private String tid;

	 private String primaryTitle;
	 
	 private int runtimeMinutes;
	 
	 private String genres;

	public MoviesDto(String tid, String primaryTitle, int runtimeMinutes, String genres) {
		
		this.tid = tid;
		this.primaryTitle = primaryTitle;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
	}
	 
	 

	   
}
