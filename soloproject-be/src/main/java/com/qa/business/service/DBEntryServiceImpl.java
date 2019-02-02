package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.DBEntryRepository;

public class DBEntryServiceImpl implements DBEntryService {
	
	@Inject
	private DBEntryRepository repo;
	
	@Override
	public String getAllDBEntry() {
		return repo.getAllDBEntry();
	}
	
	@Override
	public String getDBEntry(String foodName) {
		return repo.getDBEntry(foodName);
	}
	
	@Override
	public String addDBEntry(String dbentry) {
		return repo.addDBEntry(dbentry);
	}
	
	@Override
	public String updateDBEntry(String foodName, String dbentry) {
		return repo.updateDBEntry(foodName, dbentry);
	}
	
	@Override
	public String removeDBEntry(String foodName) {
		return repo.removeDBEntry(foodName);
	}

	public DBEntryRepository getRepo() {
		return repo;
	}

	public void setRepo(DBEntryRepository repo) {
		this.repo = repo;
	}

}
