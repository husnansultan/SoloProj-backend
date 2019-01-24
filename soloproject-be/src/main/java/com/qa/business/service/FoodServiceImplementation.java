package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Food;
import com.qa.persistence.domain.Order;
import com.qa.persistence.repository.FoodRepository;
import com.qa.persistence.repository.OrderRepository;
import com.qa.util.JSONUtil;

public class FoodServiceImplementation implements FoodService{
	@Inject
	FoodRepository repo;

	@Inject
	private JSONUtil util;

	public String getFoods() {
		return repo.getFoods();
	}

	public String addFood(String foodJSON) {
		Food food = util.getObjectForJSON(foodJSON, Food.class);
		return repo.addFood(food);
	}

	public String deleteFood(Long id) {
		return repo.deleteFood(id);
	}

	public String updateFood(Long id, String foodJSON) {
		Food food = util.getObjectForJSON(foodJSON, Food.class);
		return repo.updateFood(id, food);
	}

}
