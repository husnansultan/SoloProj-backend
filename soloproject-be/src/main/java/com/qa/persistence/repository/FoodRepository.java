package com.qa.persistence.repository;

import com.qa.persistence.domain.Food;

public interface FoodRepository {
	String getFoods();

	String addFood(Food food);

	String deleteFood(Long id);

	String updateFood(Long id, Food food);
}
