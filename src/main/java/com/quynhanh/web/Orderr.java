package com.quynhanh.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Orderr {
	// Id auto increment
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer bookId;
	
	private Integer userId;
	
	private Integer quantity;
	
}
