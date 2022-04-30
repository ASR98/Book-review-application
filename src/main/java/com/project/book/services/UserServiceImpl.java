package com.project.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.book.dao.UserDAO;
import com.project.book.model.User;
@Component
public class UserServiceImpl implements UserService{

@Autowired
private UserDAO userDAO;
//
//@Autowired
//private BCryptPasswordEncoder passwordEncoder;

@Override
public User createUser(User user) {
	userDAO.save(user);
	return user;
}

}
