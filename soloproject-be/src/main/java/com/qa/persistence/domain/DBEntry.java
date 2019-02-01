package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DBEntry")
public class DBEntry {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "userId")
	private Long userId;

	@Size(min = 0, max = 32)
	@Column(name = "foodName")
	private String foodName;
	
	@Size(min = 0, max = 32)
	@Column(name = "category")
	private String category;
	
	@Size(min = 0, max = 32)
	@Column(name = "price")
	private String price;
	
	@Size(min = 0, max = 1024)
	@Column(name = "descr")
	private String descr;
	
	@Column( name = "image")
	private String image;
	

	public DBEntry() {

	}

	public DBEntry(String foodName, String category, String price, String descr, String image) {
		this.foodName = foodName;
		this.category = category;
		this.price = price;
		this.descr = descr;
		this.image = image;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
