package com.qa.persistence.repository;

import com.qa.persistence.domain.User;

public interface UserRepository {
	String getUsers();

	String addUser(User user);

	String deleteUser(Long id);

	String updateUser(Long id, User user);
}
