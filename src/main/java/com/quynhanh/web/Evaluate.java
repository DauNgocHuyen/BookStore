package com.quynhanh.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Evaluate {

	// Id auto increment
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String evaluate;
	
	private Integer bookId;
	
	private String userName;
	
}
