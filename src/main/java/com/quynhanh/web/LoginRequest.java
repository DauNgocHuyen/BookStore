package com.quynhanh.web;

import lombok.Data;

// Define login request
@Data
public class LoginRequest {
	private String email;
	private String password;
}
