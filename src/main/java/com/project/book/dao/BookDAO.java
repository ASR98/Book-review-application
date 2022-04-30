package com.project.book.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.project.book.model.Book;
@Component
public class BookDAO extends DAO{
	public void save(Book book) {
        try {
            begin();
            getSession().save(book);
            commit();
         } catch (HibernateException e) {
            rollback();
        }
    }
	
	public List<Book> getAllBooks() {
		Query<Book> query = getSession().createQuery("FROM Book");
		List<Book> list = query.list();
		return list;
	}
	
	public Book getBook(String isbn) {
		return getSession().get(Book.class, isbn);
	}
	
}
