package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.persistence.domain.User;
import com.qa.persistence.domain.Order;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class UserMapRepository implements UserRepository {
	private Map<Long, User> users = new HashMap<>();
	Long counter = (long) 1;

	@Inject
	private JSONUtil util;

	@Override
	public String getUsers() {
		return util.getJSONForObject(users);
	}

	@Override
	@Transactional(REQUIRED)
	public String addUser(User user) {
		users.put(counter, user);
		counter++;
		return "{\"message\": \"user has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteUser(Long id) {
		if (users.containsKey(id)) {
			users.remove(id);
			return "{\"message\": \"User sucessfully deleted\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateUser(Long id, User user) {
		if (users.containsKey(id)) {
			users.remove(id);
			users.put(counter, user);
			counter++;
			return "{\"message\": \"user sucessfully updated\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}
	
	public Map<Long, User> getMap() {
		return users;
	}
	
	public boolean addOrder(Long id, Order order) {
		users.get(id).getOrders().add(order);
		return true;
	}
	
	public boolean deleteOrder(Long id, Order order) {
		users.get(id).getOrders().remove(order);
		return true;
	}

}
