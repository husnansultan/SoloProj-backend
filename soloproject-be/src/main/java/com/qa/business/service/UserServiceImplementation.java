package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

public class UserServiceImplementation implements UserService {
	@Inject
	UserRepository repo;

	@Inject
	private JSONUtil util;

	public String getUsers() {
		return repo.getUsers();
	}

	public String addUser(String userJSON) {
		User user = util.getObjectForJSON(userJSON, User.class);
		return repo.addUser(user);

	}

	public String deleteUser(Long id) {
		return repo.deleteUser(id);
	}

	public String updateUser(Long id, String userJSON) {
		User user = util.getObjectForJSON(userJSON, User.class);
		return repo.updateUser(id, user);
	}

}
