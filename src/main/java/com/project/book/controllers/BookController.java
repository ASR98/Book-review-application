package com.project.book.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.book.model.Book;
import com.project.book.model.Review;
import com.project.book.services.BookServiceImpl;
import com.project.book.util.FileUploadUtil;

@Controller
public class BookController {
	@Autowired
	private BookServiceImpl bookServiceImpl;
@GetMapping("/addBookForm")
public String openAddBookForm(Model model) {
	 model.addAttribute("book", new Book());
	return "add_book_form";
}

@PostMapping("/plan")
public String addBook(Book book, @RequestParam("image") MultipartFile multipartFile) {
	String fileName = "image_" + book.getIsbn();
	book.setBookImage(fileName);
	Book book1 = bookServiceImpl.addBook(book);
    String uploadDir = "book-images/" + book1.getId();
    try {
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "add_book_success";
}

@GetMapping("")
public String getAllBooks(Model model) {
	model.addAttribute("books", bookServiceImpl.getAllBooks());
	return "index";
}

@GetMapping("/getBook")
public String getBookByISBN(@RequestParam("isbn") String isbn, Model model) {
	Book book = bookServiceImpl.getBookByISBN(isbn);
	System.out.println("book" + book);
	model.addAttribute("book", book);
	 model.addAttribute("review", new Review());
	return "book-details";
}
}
