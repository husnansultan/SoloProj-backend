package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.DBEntry;
import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

public class DBEntryRepositoryImpl implements DBEntryRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllDBEntry() {
		Query query = manager.createQuery("SELECT d FROM DBEntry d");
		Collection<DBEntry> dbentry = (Collection<DBEntry>)query.getResultList();
		return util.getJSONForObject(dbentry);
	}
	
	@Override
	public String getDBEntry(String foodName) {
		Query query = manager.createQuery("Select a FROM DBEntry a WHERE a.foodName = :foodName");
		query.setParameter("foodName", foodName);
		@SuppressWarnings("unchecked")
		Collection<DBEntry> entries = (Collection<DBEntry>) query.getResultList();
		return util.getJSONForObject(entries);
	}
	
	public DBEntry findDBEntry(Long id) {
		return manager.find(DBEntry.class, id);
	}
	
	public Long getIdFromfoodName(String foodName) {
		Query query = manager.createQuery("Select id FROM DBEntry a WHERE a.foodName = :foodName");
		query.setParameter("foodName", foodName);
		@SuppressWarnings("unchecked")
		List<Long> entries = (List<Long>) query.getResultList();
		long uID = entries.get(0);
		return uID;
	}
	
	@Override
	@Transactional(REQUIRED)
	public String addDBEntry(String dbentry) {
		DBEntry aDBEntry = util.getObjectForJSON(dbentry, DBEntry.class);
		manager.persist(aDBEntry);
		return "{\"message\": \"database entry has been sucessfully added\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateDBEntry(String foodName, String dbentry) {
		Long id= getIdFromfoodName(foodName);
		DBEntry entryInDB = findDBEntry(id);
		if (entryInDB != null) {
			manager.remove(entryInDB);
			DBEntry entryUpdateInDB = util.getObjectForJSON(dbentry, DBEntry.class);
			manager.persist(entryUpdateInDB);
		}
		return "{\"message\": \"database entry has been sucessfully updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String removeDBEntry(String foodName) {
		Long id = getIdFromfoodName(foodName);
		DBEntry entryInDB = findDBEntry(id);
		if (entryInDB != null) {
			manager.remove(entryInDB);
		}
		return "{\"message\": \"database entry has been sucessfully removed\"}";
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
