package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.DBEntryRepository;

public class DBEntryServiceImpl implements DBEntryService {
	
	@Inject
	private DBEntryRepository repo;
	
	@Override
	public String getDBEntry(String greekName) {
		return repo.getDBEntry(greekName);
	}
	
	@Override
	public String addDBEntry(String dbentry) {
		return repo.addDBEntry(dbentry);
	}
	
	@Override
	public String updateDBEntry(String greekName, String dbentry) {
		return repo.updateDBEntry(greekName, dbentry);
	}
	
	@Override
	public String removeDBEntry(String greekName) {
		return repo.removeDBEntry(greekName);
	}

	public DBEntryRepository getRepo() {
		return repo;
	}

	public void setRepo(DBEntryRepository repo) {
		this.repo = repo;
	}

}
