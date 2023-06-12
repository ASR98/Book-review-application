package com.project.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.project.book.dao.ReviewDAO;
import com.project.book.model.Review;
@Component
public class ReviewServiceImpl implements ReviewService{
@Autowired
private ReviewDAO reviewDAO;
	@Override
	public Review addReview(Review review) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("username"+auth.getName());
		// TODO Auto-generated method stub
		reviewDAO.save(review);
		return review;
	}

	@Override
	public Review addRating(Review review) {
		// TODO Auto-generated method stub
		reviewDAO.save(review);
		return review;
	}

}
