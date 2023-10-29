package com.quynhanh.web;

import lombok.Data;

@Data
public class BookRequest {
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
