package io.egen.movieflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.User;
@Repository
public class UserRepositoryImp implements UserRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class);
		query.setParameter("username", username);
		User user = query.getSingleResult();
		return user;
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return user;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createNamedQuery("User.findByCredentials", User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		User user = query.getSingleResult();
		return user;
	}

}
