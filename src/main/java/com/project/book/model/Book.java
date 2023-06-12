package com.project.book.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "books")
public class Book {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 @Column(nullable = false, unique = true, length = 13)
	    private String isbn;
	     
	    @Column(name = "book_name", nullable = false, length = 64)
	    private String bookName;
	     
	    @Column(name = "author", nullable = false)
	    private String author;
	     
	    @Column(name = "genre", nullable = false)
	    private String genre;
	    
	    @Column(name="image")
	    private String bookImage;
	    
	    @Column(name="description")
	    private String description;
	    
	    @ManyToOne
	    private User user;
	    
	    @OneToMany(mappedBy = "book")
	    private Set<Review> reviews = new HashSet<Review>();
	    
		@Transient
		private String imageFilePath;
		
		public String getBookImage() {
			return bookImage;
		}

		public String getImageFilePath() {
			if (bookImage == null || id == null) return null;
	         
	        return "/book-images/" + id + "/" + bookImage;
		}

		public void setImageFilePath(String imageFilePath) {
			this.imageFilePath = imageFilePath;
		}

		public void setBookImage(String bookImage) {
			this.bookImage = bookImage;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
}
