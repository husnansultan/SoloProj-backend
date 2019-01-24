package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long foodid;

	private String name;
	private String category;
	private Long price;

	public Food() {

	}

	public Food(String name, String category, Long price) {
		this.setName(name);
		this.setCategory(category);
		this.setPrice(price);
	}
	
	public Long getFoodid() {
		return foodid;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
}
