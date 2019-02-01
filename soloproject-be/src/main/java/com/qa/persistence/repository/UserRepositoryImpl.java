package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

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
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	

	public User findUser(Long userId) {
		return manager.find(User.class, userId);
	}
	
	public Long getIdFromUserName(String userName) {
		Query query = manager.createQuery("Select userId FROM User a WHERE a.userName = :userName");
		query.setParameter("userName", userName);
		@SuppressWarnings("unchecked")
		List<Long> entries = (List<Long>) query.getResultList();
		long uID = entries.get(0);
		return uID;
	}
	
	@Override
	@Transactional(REQUIRED)
	public String addUser(String user) {
		User aUser = util.getObjectForJSON(user, User.class);
		manager.persist(aUser);
		return "{\"message\": \"user has been sucessfully added\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateUser(String userName, String user) {
		Long userId= getIdFromUserName(userName);
		User userInDB = findUser(userId);
		if (userInDB != null) {
			manager.remove(userInDB);
			User userUpdateInDB = util.getObjectForJSON(user, User.class);
			manager.persist(userUpdateInDB);
		}
		return "{\"message\": \"user has been sucessfully updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String removeUser(String userName) {
		Long userId= getIdFromUserName(userName);
		User userInDB = findUser(userId);
		if (userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"user has been sucessfully removed\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
