package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository repo;

	@Override
	public String getAllUsers() {
		return repo.getAllUsers();
	}
	
	@Override
	public String getUser(String userName) {
		return repo.getUser(userName);
	}

	@Override
	public String addUser(String user) {
		return repo.addUser(user);
	}

	@Override
	public String updateUser(String userName, String user) {
		return repo.updateUser(userName, user);
	}

	@Override
	public String removeUser(String userName) {
		return repo.removeUser(userName);
	}

	public UserRepository getRepo() {
		return repo;
	}

	public void setRepo(UserRepository repo) {
		this.repo = repo;
	}

}
