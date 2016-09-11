package io.egen.movieflix.repository;

import io.egen.movieflix.entity.User;

public interface UserRepository {

	public User findOne(String username);

	public User create(User user);

	public User login(String username, String password);

}
