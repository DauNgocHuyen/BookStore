package com.quynhanh.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	// Show login page
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	// Check login
	@PostMapping("/login")
	public String checkLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request, Model model) throws Exception {
		User user = authService.checkLogin(email, password);
		if(user == null) {
			model.addAttribute("error", "Thông tin đăng nhập không đúng!");
			return "login";
		}
		
		// set user attribute into session
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("role", user.getRole());
		return "index";
	}
	
	// Show register page
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	// Register new account
	@PostMapping("/register")
	public String register(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpServletRequest request) throws Exception {
		List<User> users = userRepository.findAll();
		// check email existed
		for(User user : users) {
			if(user.getEmail().equals(email)) {
				model.addAttribute("error", "Email đã được đăng ký!");
				return "register";
			}
		}
		
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setRole("USER");
		
		userService.createNewAccount(user);		// Save user info into Database
		return "index";
	}
	
	// Logout
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// Xóa role khỏi session:
		session.removeAttribute("role");
		// Xóa user khỏi session:
		session.removeAttribute("user");
		
		
		return "index";
	}
	
}
