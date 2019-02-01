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

	@Path("/getDBEntry/{greekName}")
	@GET
	@Produces({ "application/json" })
	public String getDBEntry(@PathParam("greekName") String greekName) {
		return service.getDBEntry(greekName);
	}
	
	@Path("/addDBEntry/")
	@POST
	@Produces({ "application/json" })
	public String addDBEntry(String dbentry) {
		return service.addDBEntry(dbentry);
	}

	@Path("/updateDBEntry/{greekName}")
	@PUT
	@Produces({ "application/json" })
	public String updateDBEntry(@PathParam("greekName") String greekName, String dbentry) {
		return service.updateDBEntry(greekName, dbentry);
	}

	@Path("/removeDBEntry/{greekName}")
	@DELETE
	@Produces({ "application/json" })
	public String removeDBEntry(@PathParam("greekName") String greekName) {
		return service.removeDBEntry(greekName);
	}
	
	public DBEntryService getService() {
		return service;
	}

	public void setService(DBEntryService service) {
		this.service = service;
	}

}
