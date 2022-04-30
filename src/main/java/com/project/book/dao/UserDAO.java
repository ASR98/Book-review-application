package com.project.book.dao;


import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.project.book.model.Book;
import com.project.book.model.User;
@Component
public class UserDAO extends DAO{
	public void save(User user) {
        try {
            begin();
            getSession().save(user);
            commit();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
	
	public User findByEmail(String email) {
		Query query = getSession().createQuery("FROM User WHERE email = :email");
		query.setParameter("email", email);
		return (User) query.uniqueResult();
//		return (User) getSession().createQuery("Select * from users u where u.email=:email").setParameter("email", email).uniqueResult();
	}
	
}