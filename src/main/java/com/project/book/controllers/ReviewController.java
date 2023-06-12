package com.project.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.book.model.Review;
import com.project.book.services.ReviewServiceImpl;

@Controller
public class ReviewController {
	@Autowired
	private ReviewServiceImpl reviewServiceImpl;
@PostMapping("/add_review")
public String addReview(Review review) {
	reviewServiceImpl.addReview(review);
	return "register_success";
}
}
