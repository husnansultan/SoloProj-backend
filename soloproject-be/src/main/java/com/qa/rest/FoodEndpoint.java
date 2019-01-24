package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.service.FoodService;

@Path("/food")
public class FoodEndpoint {
	@Inject
	private FoodService service;
	
	@Path("/json")
	@GET
	public String getFoods() {
		return service.getFoods();
	}
	
	@Path("/json")
	@POST
	public String addFood(String food) {
		return service.addFood(food);
	}

	@Path("/json/{id}")
	@DELETE
	public String deleteFood(@PathParam("id") Long id) {
		return service.deleteFood(id);
	}

	@Path("/json/{id}")
	@PUT
	public String updateFood(@PathParam("id") Long id, String food) {
		return service.updateFood(id, food);
	}
}