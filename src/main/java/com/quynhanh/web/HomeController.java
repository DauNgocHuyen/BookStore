package com.quynhanh.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {
	
	@Autowired 
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private EvaluateRepository evaluateRepository;
	
	// Show home page
	@GetMapping("/")
	public String homePage(Model model , HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Book> books = bookRepository.findAll(); // Lấy ra danh sách tất cả các sách
		session.setAttribute("books", books);	// Lưu danh sách các sách vào session
		
		// save all category into session 
		List<Category> categories = categoryService.getAlls();	// Lấy ra tất cả các danh mục
		model.addAttribute("categories", categories);
		session.setAttribute("categories", categories);	// Lưu tất cả danh mục vào session
		
		return "index";
	}
	
	// Show view page
	@GetMapping("/view/{id}")
	public String viewPage(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		// save all category into session 
		HttpSession session = request.getSession();
		List<Category> categories = categoryService.getAlls();	// Lấy ra tất cả các danh mục
		model.addAttribute("categories", categories);
		session.setAttribute("categories", categories);	// Lưu tất cả danh mục vào session
		Book book = bookRepository.getById(id);
		model.addAttribute("book", book);
		
		// Get all evaluate with book id
		List<Evaluate> evaluates = evaluateRepository.findByBookId(id);
		model.addAttribute("evaluates", evaluates);
		
		return "view";
	}
	
	// Show add book page
	@GetMapping("/add-book")
	public String addBookPage(Model model) {
		
		return "view";
	}
	
	// Show order page
	@GetMapping("/list-order")
	public String viewOrder(Model model, HttpServletRequest request) {
		// Get list order
		// Get user id and list book id
		List<Orderr> orders = orderRepository.findAll();
		HttpSession session = request.getSession();
		
		// get user id
		User user = (User) session.getAttribute("user");
		
		// Load order data
		List<OrderData> datas = new ArrayList<OrderData>();
		for(Orderr order : orders) {
			if(order.getUserId() == user.getId()) {
				Book book = bookRepository.getById(order.getBookId());
				OrderData orderData = new OrderData();
				orderData.setBook(book);
				orderData.setOrderId(order.getId());
				datas.add(orderData);
			}
		}
	
		model.addAttribute("datas", datas);
		return "order";
	}
	
	
}
