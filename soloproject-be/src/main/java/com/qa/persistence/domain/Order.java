package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long orderid;

	private List<Food> foods;

	private Long userid;

	public Order() {

	}

	public Order(List<Food> foods) {
		this.foods = foods;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Long getUserid() {
		return userid;
	}

	public Long setUserid() {
		return userid;
	}

}
