package com.qa.persistence.repository;

public interface UserRepository {
	
	String addUser(String user);
	String updateUser(String userName, String user);
	String removeUser(String userName);
	String getAllUsers();

}
