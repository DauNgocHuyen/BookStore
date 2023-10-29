package com.quynhanh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookController {
	
	@Autowired 
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Add book into DB
	@PostMapping("/add-book")
	public Book createNewBook(@RequestBody BookRequest bookRequest) {
		Book book = new Book();	// create new book
		
		// get category name by id
		String category = categoryRepository.getById(new Integer(bookRequest.getCategory())).getName();
		book.setAuthor(bookRequest.getAuthor());
		book.setCategory(category);
		book.setDescription(bookRequest.getDescription());
		book.setImage(bookRequest.getImage());
		book.setNumberOfPages(bookRequest.getNumberOfPages());
		book.setReleaseDate(bookRequest.getReleaseDate());
		book.setTitle(bookRequest.getTitle());
		book.setPrice(bookRequest.getPrice());
		
		// save new book into DB
		return bookRepository.save(book);
	}
	
	// Update book into DB
	@PostMapping("/update-book")
	public Book updateBook(@RequestBody BookRequest bookRequest) {
		Book book = new Book();
		
		book.setId(bookRequest.getId());
		// get category name by id
		String category = categoryRepository.getById(new Integer(bookRequest.getCategory())).getName();
		book.setAuthor(bookRequest.getAuthor());
		book.setCategory(category);
		book.setDescription(bookRequest.getDescription());
		book.setImage(bookRequest.getImage());
		book.setNumberOfPages(bookRequest.getNumberOfPages());
		book.setReleaseDate(bookRequest.getReleaseDate());
		book.setTitle(bookRequest.getTitle());
		book.setPrice(bookRequest.getPrice());
		
		// save book update
		return bookRepository.save(book);
	}
	
	// Delete book by id
	@PostMapping("/delete")
	public int deleteBook(@RequestBody int bookId) {
		// delete book by id
		bookRepository.deleteById(bookId);
		return 1;
	}
	
	
	
	
}
