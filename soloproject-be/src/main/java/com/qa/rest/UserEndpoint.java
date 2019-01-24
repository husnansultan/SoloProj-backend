package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.service.UserService;

@Path("/user")
public class UserEndpoint {
	@Inject
	private UserService service;
	
	@Path("/json")
	@GET
	public String getUsers() {
		return service.getUsers();
	}
	
	@Path("/json")
	@POST
	public String addUser(String user) {
		return service.addUser(user);
	}

	@Path("/json/{id}")
	@DELETE
	public String deleteUser(@PathParam("id") Long id) {
		return service.deleteUser(id);
	}

	@Path("/json/{id}")
	@PUT
	public String updateUser(@PathParam("id") Long id, String user) {
		return service.updateUser(id, user);
	}
}
