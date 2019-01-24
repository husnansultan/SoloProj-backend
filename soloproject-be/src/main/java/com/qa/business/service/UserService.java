package com.qa.business.service;

public interface UserService {

	public String getUsers();

	public String addUser(String userJSON);

	public String deleteUser(Long id);

	public String updateUser(Long id, String userJSON);

}
