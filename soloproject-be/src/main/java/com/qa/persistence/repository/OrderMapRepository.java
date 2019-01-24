package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Order;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class OrderMapRepository implements OrderRepository {
	private Map<Long, Order> orders = new HashMap<>();
	Long counter = (long) 1;
	
	UserMapRepository repo = new UserMapRepository();

	@Inject
	private JSONUtil util;
	
	@Override
	public String getOrders() {
		return util.getJSONForObject(orders);
	}

	@Override
	public String addOrder(Order order) {
		if (repo.getMap().containsKey(order.getUserid())) {
			orders.put(counter, order);
			repo.addOrder(order.getUserid(), order);
			counter++;
			return "{\"message\": \"order sucessfully added\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}

	@Override
	public String deleteOrder(Long id) {
		if (orders.containsKey(id)) {
			orders.remove(id);
			repo.deleteOrder(orders.get(id).getUserid(), orders.get(id));
			return "{\"message\": \"order sucessfully deleted\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}

	@Override
	public String updateOrder(Long id, Order order) {
		if (repo.getMap().containsKey(order.getUserid())) {
			if (orders.containsKey(id)) {
				deleteOrder(id);
				addOrder(order);
				return "{\"message\": \"order sucessfully updated\"}";
			}
			return "{\"message\": \"order does not exist\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}

}
