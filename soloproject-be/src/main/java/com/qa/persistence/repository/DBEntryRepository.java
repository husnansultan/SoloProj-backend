package com.qa.persistence.repository;

public interface DBEntryRepository {

	String getDBEntry(String greekName);
	String addDBEntry(String dbentry);
	String updateDBEntry(String greekName, String dbentry);
	String removeDBEntry(String greekName);

}
