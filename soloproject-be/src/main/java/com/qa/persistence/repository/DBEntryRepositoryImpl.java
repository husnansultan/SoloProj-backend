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

public class DBEntryRepositoryImpl implements DBEntryRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getDBEntry(String greekName) {
		Query query = manager.createQuery("Select a FROM DBEntry a WHERE a.greekName = :greekName");
		query.setParameter("greekName", greekName);
		@SuppressWarnings("unchecked")
		Collection<DBEntry> entries = (Collection<DBEntry>) query.getResultList();
		return util.getJSONForObject(entries);
	}
	
	public DBEntry findDBEntry(Long id) {
		return manager.find(DBEntry.class, id);
	}
	
	public Long getIdFromGreekName(String greekName) {
		Query query = manager.createQuery("Select id FROM DBEntry a WHERE a.greekName = :greekName");
		query.setParameter("greekName", greekName);
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
	public String updateDBEntry(String greekName, String dbentry) {
		Long id= getIdFromGreekName(greekName);
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
	public String removeDBEntry(String greekName) {
		Long id = getIdFromGreekName(greekName);
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
