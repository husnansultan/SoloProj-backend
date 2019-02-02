package com.qa.persistence.repository;

public interface DBEntryRepository {
	
	String getAllDBEntry();
	String getDBEntry(String foodName);
	String addDBEntry(String dbentry);
	String updateDBEntry(String foodName, String dbentry);
	String removeDBEntry(String foodName);

}
