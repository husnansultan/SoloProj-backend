package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.DBEntryService;

@Path("/fetch")
public class DBEntryEndpoints {
	
	@Inject
	private DBEntryService service;

	@Path("getAllDBEntry")
	@GET
	@Produces({ "application/json" })
	public String getAllDBEntry() {
		return service.getAllDBEntry();
	}
	
	@Path("/getDBEntry/{foodName}")
	@GET
	@Produces({ "application/json" })
	public String getDBEntry(@PathParam("foodName") String foodName) {
		return service.getDBEntry(foodName);
	}
	
	@Path("/addDBEntry/")
	@POST
	@Produces({ "application/json" })
	public String addDBEntry(String dbentry) {
		return service.addDBEntry(dbentry);
	}

	@Path("/updateDBEntry/{foodName}")
	@PUT
	@Produces({ "application/json" })
	public String updateDBEntry(@PathParam("foodName") String foodName, String dbentry) {
		return service.updateDBEntry(foodName, dbentry);
	}

	@Path("/removeDBEntry/{foodName}")
	@DELETE
	@Produces({ "application/json" })
	public String removeDBEntry(@PathParam("foodName") String foodName) {
		return service.removeDBEntry(foodName);
	}
	
	public DBEntryService getService() {
		return service;
	}

	public void setService(DBEntryService service) {
		this.service = service;
	}

}
