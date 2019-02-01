package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.UserService;

@Path("/fetchUser")
public class UserEndpoints {
	
	@Inject
	private UserService service;
	
	@Path("/addUser/")
	@POST
	@Produces({ "application/json" })
	public String addUser(String user) {
		return service.addUser(user);
	}

	@Path("/updateUser/{userName}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("userName") String userName, String user) {
		return service.updateUser(userName, user);
	}

	@Path("/removeUser/{userName}")
	@DELETE
	@Produces({ "application/json" })
	public String removeUser(@PathParam("userName") String userName) {
		return service.removeUser(userName);
	}
	
	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

}
