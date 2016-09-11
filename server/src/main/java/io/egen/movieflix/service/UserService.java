package io.egen.movieflix.service;

import io.egen.movieflix.entity.User;

public interface UserService {

	public User findOne(String username);

	public User create(User user);

	public User login(String username, String password);

}
