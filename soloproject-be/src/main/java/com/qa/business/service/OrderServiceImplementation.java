package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Order;
import com.qa.persistence.repository.OrderRepository;
import com.qa.util.JSONUtil;

public class OrderServiceImplementation implements OrderService {
	@Inject
	OrderRepository repo;

	@Inject
	private JSONUtil util;

	public String getOrders() {
		return repo.getOrders();
	}

	public String addOrder(String orderJSON) {
		Order order = util.getObjectForJSON(orderJSON, Order.class);
		return repo.addOrder(order);
	}

	public String deleteOrder(Long id) {
		return repo.deleteOrder(id);
	}

	public String updateOrder(Long id, String orderJSON) {
		Order order = util.getObjectForJSON(orderJSON, Order.class);
		return repo.updateOrder(id, order);
	}

}
