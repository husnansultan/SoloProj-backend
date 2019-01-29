package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long orderid;

	@OneToMany(mappedBy = "orderid", cascade = CascadeType.ALL)
//	@JoinColumn(name = "orderid")
	private List<Food> foods = new ArrayList<>();

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
