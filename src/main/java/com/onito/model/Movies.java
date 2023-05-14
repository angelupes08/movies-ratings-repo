package com.onito.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="movies")
public class Movies {
	
	@Id
	@Column(name = "tconst")
	private String tid;
	
	@Column(name="titleType")
	private String titleType;
	@Column(name="primaryTitle")
	private String primaryTitle;
	@Column(name="runtimeMinutes")
	private int runtimeMinutes;
	@Column(name="genres")
	private String genres;
	
	@OneToOne(mappedBy = "movies",cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Ratings ratings;
	
}
