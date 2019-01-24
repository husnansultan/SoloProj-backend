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

import com.qa.persistence.domain.Food;

import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class FoodDBRepository implements FoodRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getFoods() {
		Query query = manager.createQuery("SELECT f FROM Food f");
		Collection<Food> foods = (Collection<Food>) query.getResultList();
		return util.getJSONForObject(foods);
	}

	@Transactional(REQUIRED)
	public String addFood(Food food) {
		Food cfood = findFood(food.getFoodid());
		if (cfood != null) {
			manager.persist(food);
			return "{\"message\": \"food sucessfully added\"}";
		}
		return "{\"message\": \"food already exists\"}";
	}

	@Transactional(REQUIRED)
	public String deleteFood(Long id) {
		Food foodInDB = findFood(id);
		if (foodInDB != null) {
			manager.remove(foodInDB);
			return "{\"message\": \"food sucessfully deleted\"}";
		}
		return "{\"message\": \"food does not exist\"}";
	}

	@Transactional(REQUIRED)
	public String updateFood(Long id, Food food) {
		Food cfood = findFood(food.getFoodid());
		if (cfood != null) {
			Food foodInDB = findFood(id);
			if (foodInDB != null) {
				manager.remove(foodInDB);
				manager.persist(food);
				return "{\"message\": \"food sucessfully updated\"}";
			}
			return "{\"message\": \"food does not exist\"}";
		}
		return "{\"message\": \"foods does not exist\"}";
	}

	private Food findFood(Long id) {
		return manager.find(Food.class, id);
	}
}
