package com.project.book.services;

import com.project.book.model.Review;

public interface ReviewService {
Review addReview(Review review);
Review addRating(Review review);
}
