package com.in28minutes.rest.webservices.restful.controllers.users;

import com.in28minutes.rest.webservices.restful.controllers.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

	@PersistenceContext
	private EntityManager manager;

	public UserRepository(){}

	public List<User> findAll() {
		TypedQuery<User> query = manager.createNamedQuery("find_all_users", User.class);
		return query.getResultList();
	}

	public User findById(Integer id) {
		return manager.find(User.class, id);
	}

	public User updateUser(User u) throws Exception {
		return manager.merge(u);
	}

	public User insertUser(User u) throws Exception {
		return manager.merge(u);
	}

	public User removeUserById(Integer id) throws Exception {
		User user = this.findById(id);
		if (user == null){
			throw new UserNotFoundException(id);
		}
		manager.remove(user);
		return user;
	}
}
