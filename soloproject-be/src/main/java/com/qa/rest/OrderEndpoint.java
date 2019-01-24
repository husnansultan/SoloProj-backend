package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.service.OrderService;

@Path("/order")
public class OrderEndpoint {
	@Inject
	private OrderService service;
	
	@Path("/json")
	@GET
	public String getOrders() {
		return service.getOrders();
	}
	
	@Path("/json")
	@POST
	public String addOrder(String order) {
		return service.addOrder(order);
	}

	@Path("/json/{id}")
	@DELETE
	public String deleteOrder(@PathParam("id") Long id) {
		return service.deleteOrder(id);
	}

	@Path("/json/{id}")
	@PUT
	public String updateOrder(@PathParam("id") Long id, String order) {
		return service.updateOrder(id, order);
	}
}
