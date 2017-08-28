package com.libertymutual.goforcode.wimp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=300)
	private String title;
	
	
	@Column(nullable=true)
	private Date releaseDate;
	
	@Column(nullable=true)
	private long budget;
	
	@Column(nullable=true)
	private String distributor;
		
		}
