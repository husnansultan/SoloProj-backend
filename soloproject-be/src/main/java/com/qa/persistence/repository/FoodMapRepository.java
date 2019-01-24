package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.qa.persistence.domain.Food;
import com.qa.util.JSONUtil;

public class FoodMapRepository implements FoodRepository {
	private Map<Long, Food> foods = new HashMap<>();
	Long counter = (long) 1;

	@Inject
	private JSONUtil util;


	@Override
	public String getFoods() {
		return util.getJSONForObject(foods);
	}

	@Override
	public String addFood(Food food) {
		foods.put(counter, food);
		counter++;
		return "{\"message\": \"food has been sucessfully added\"}";
	}

	@Override
	public String deleteFood(Long id) {
		if (foods.containsKey(id)) {
			foods.remove(id);
			return "{\"message\": \"food sucessfully deleted\"}";
		}
		return "{\"message\": \"user does not exist\"}";
	}

	@Override
	public String updateFood(Long id, Food food) {
		if (foods.containsKey(id)) {
			foods.remove(id);
			foods.put(counter, food);
			counter++;
			return "{\"message\": \"food sucessfully updated\"}";
		}
		return "{\"message\": \"food does not exist\"}";
	}

}
