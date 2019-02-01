package com.qa.business.service;

public interface DBEntryService {
	
	String getDBEntry(String greekName);
	String addDBEntry(String dbentry);
	String updateDBEntry(String greekName, String dbentry);
	String removeDBEntry(String greekName);

}