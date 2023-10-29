package com.quynhanh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	// Create new order
	@PostMapping("/order")
	public int createOrder(@RequestBody Orderr order) {
		orderRepository.save(order);
		return 1;
	}
	
	// Delete order by id
	@PostMapping("/order/delete")
	public int delete(@RequestBody Integer id) {
		orderRepository.deleteById(id);
		return 1;
	}
	
}
