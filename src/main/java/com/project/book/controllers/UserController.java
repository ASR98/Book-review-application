package com.project.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.book.dao.UserDAO;
import com.project.book.model.User;
import com.project.book.services.UserService;
import com.project.book.services.UserServiceImpl;

@Controller
public class UserController {
@Autowired
private UserServiceImpl userServiceImpl;
@GetMapping("")
public String viewHomePage() {
    return "index";
}
@RequestMapping(value = "/register_user", method=RequestMethod.POST)
public String registerUser(User user) {
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
String encodedPassword = passwordEncoder.encode(user.getPassword());
user.setPassword(encodedPassword);
userServiceImpl.createUser(user);
return "register_success";
}
@RequestMapping(value="/register", method=RequestMethod.GET)
public String openRegistrationForm(Model model){
	 model.addAttribute("user", new User());
     
	    return "registration_form";
	
}
}
