package com.project.book.dao;

import org.springframework.stereotype.Component;

import com.project.book.model.Review;
@Component
public class ReviewDAO extends DAO{
	public void save(Review review) {
        try {
            begin();
            getSession().save(review);
            commit();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
