package io.egen.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.service.UserService;

@RestController
@RequestMapping(value="/user", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	@Autowired
	private UserService service;
	
	public User findOne(String username){
		return service.findOne(username);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user){
		return service.create(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public User login(@RequestBody User user){
		return service.login(user.getUsername(), user.getPassword());
	}
}
