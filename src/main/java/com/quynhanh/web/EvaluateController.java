package com.quynhanh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluateController {
	@Autowired
	private EvaluateRepository evaluateRepository;
	
	// Create new evaluate
	@PostMapping("/evaluate")
	public int createNew(@RequestBody EvaluateData data) {
		// create new evaluate
		Evaluate newEvaluate = new Evaluate();
		newEvaluate.setEvaluate(data.getEvaluate());
		newEvaluate.setBookId(data.getBookId());
		newEvaluate.setUserName(data.getUserName());
		newEvaluate = evaluateRepository.save(newEvaluate);
		
		return 1;
	}
	
}
