package com.quynhanh.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Book {
	// Id auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String category;
	
	private String image;
	
	private String author;
	
	private String releaseDate;
	
	private Integer numberOfPages;
	
	private String description;
	
	private Integer price;
	
}
