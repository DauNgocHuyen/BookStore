package com.quynhanh.web;

public interface AuthService {
	User checkLogin(String email, String password);
}
