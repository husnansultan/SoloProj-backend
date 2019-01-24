package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.User;
import com.qa.persistence.domain.Order;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class OrderDBRepository implements OrderRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getOrders() {
		Query query = manager.createQuery("SELECT o FROM Order o");
		Collection<Order> orders = (Collection<Order>) query.getResultList();
		return util.getJSONForObject(orders);
	}

	@Transactional(REQUIRED)
	public String addOrder(Order order) {
		User user = findUser(order.getUserid());
		if (user != null) {
			manager.persist(order);
			return "{\"message\": \"order sucessfully added\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}

	@Transactional(REQUIRED)
	public String deleteOrder(Long id) {
		Order orderInDB = findOrder(id);
		if (orderInDB != null) {
			manager.remove(orderInDB);
			return "{\"message\": \"order sucessfully deleted\"}";
		}
		return "{\"message\": \"order does not exist\"}";
	}

	@Transactional(REQUIRED)
	public String updateOrder(Long id, Order order) {
		User user = findUser(order.getUserid());
		if (user != null) {
			Order orderInDB = findOrder(id);
			if (orderInDB != null) {
				manager.remove(orderInDB);
				manager.persist(order);
				return "{\"message\": \"order sucessfully updated\"}";
			}
			return "{\"message\": \"order does not exist\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}

	private Order findOrder(Long id) {
		return manager.find(Order.class, id);
	}

	private User findUser(Long id) {
		return manager.find(User.class, id);
	}

}
