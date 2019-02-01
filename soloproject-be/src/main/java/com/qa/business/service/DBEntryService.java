package com.qa.business.service;

public interface DBEntryService {
	
	String getDBEntry(String foodName);
	String addDBEntry(String dbentry);
	String updateDBEntry(String foodName, String dbentry);
	String removeDBEntry(String foodName);

}