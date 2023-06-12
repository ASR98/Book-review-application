package com.project.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 	@Column
	    private String reviewDesc;
	     
	 	@Column
	 	private double ratings;
	 	
	 	@ManyToOne
	 	private User user;
	 	
	 	@ManyToOne
	 	private Book book;
	 	
//	 	@Column
//	 	private long user_id;
//	 	
//	 	@Column
//	 	private long book_id;
	 	
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getReviewDesc() {
			return reviewDesc;
		}

		public void setReviewDesc(String reviewDesc) {
			this.reviewDesc = reviewDesc;
		}

		public double getRatings() {
			return ratings;
		}

		public void setRatings(double ratings) {
			this.ratings = ratings;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}

//		public long getUser_id() {
//			return user_id;
//		}
//
//		public void setUser_id(long user_id) {
//			this.user_id = user_id;
//		}

//		public long getBook_id() {
//			return book_id;
//		}
//
//		public void setBook_id(long book_id) {
//			this.book_id = book_id;
//		}
	   
}
