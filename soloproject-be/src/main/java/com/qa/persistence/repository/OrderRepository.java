package com.qa.persistence.repository;

import com.qa.persistence.domain.Order;

public interface OrderRepository {
	String getOrders();

	String addOrder(Order order);

	String deleteOrder(Long id);

	String updateOrder(Long id, Order order);
}
