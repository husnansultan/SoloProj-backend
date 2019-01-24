package com.qa.business.service;

public interface OrderService {

	public String getOrders();

	public String addOrder(String orderJSON);

	public String deleteOrder(Long id);

	public String updateOrder(Long id, String orderJSON);

}
