package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class UserDBRepository implements UserRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getUsers() {
		Query query = manager.createQuery("SELECT u FROM User u");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}

	@Transactional(REQUIRED)
	public String addUser(User user) {
		manager.persist(user);
		return "{\"message\": \"user has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteUser(Long id) {
		User userInDB = findUser(id);
		if (userInDB != null) {
			manager.remove(userInDB);
			return "{\"message\": \"user sucessfully deleted\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}

	@Transactional(REQUIRED)
	public String updateUser(Long id, User user) {
		User userInDB = findUser(id);
		if (userInDB != null) {
			manager.remove(userInDB);
			manager.persist(user);
			return "{\"message\": \"user sucessfully updated\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}

	private User findUser(Long id) {
		return manager.find(User.class, id);
	}

}
