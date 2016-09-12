package io.egen.movieflix.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.exception.EntityAlreadyExistsException;
import io.egen.movieflix.exception.InvalidPasswordException;
import io.egen.movieflix.repository.UserRepository;
@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository repository;
	
	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		User user = repository.findOne(username);
		if(user == null){
			throw new EntityNotFoundException("User not found");
		}
		return user;
	}
	
	@Transactional
	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		User user1 = repository.findOne(user.getUsername());
		if (user1 != null) {
			throw new EntityAlreadyExistsException("Username already present");
		}
		return repository.create(user);
	}
	
	@Transactional
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = repository.findOne(username);
		if (user == null) {
			throw new EntityNotFoundException("Username does not exist");
		}
		if(!user.getPassword().equals(password)){
			throw new InvalidPasswordException("Password incorrect");
		}
		return repository.login(username, password);
	}

}
