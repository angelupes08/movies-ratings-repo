package com.onito.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ratings")
public class Ratings {
	
	
	@Id
	@Column(name="tconst")
	private String tid;
	
	@Column(name="averageRating")
	private java.math.BigDecimal averageRating;
	
	@Column(name="numVotes")
	private int numVotes;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "tconst")
    private Movies movies;
	
	

}
