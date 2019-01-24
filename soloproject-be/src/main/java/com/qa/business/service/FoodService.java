package com.qa.business.service;

public interface FoodService {

	public String getFoods();

	public String addFood(String foodJSON);

	public String deleteFood(Long id);

	public String updateFood(Long id, String foodJSON);
}
