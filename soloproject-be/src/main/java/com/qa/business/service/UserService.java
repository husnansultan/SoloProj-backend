package com.qa.business.service;

public interface UserService {
	
	String addUser(String user);
	String updateUser(String userName, String user);
	String removeUser(String userName);
	String getAllUsers();
	String getUser(String userName);

}
