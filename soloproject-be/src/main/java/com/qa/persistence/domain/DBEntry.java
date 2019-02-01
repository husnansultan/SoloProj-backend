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
	@Column(name = "greekName")
	private String greekName;
	
	@Size(min = 0, max = 32)
	@Column(name = "romanName")
	private String romanName;
	
	@Size(min = 0, max = 32)
	@Column(name = "consort")
	private String consort;
	
	@Size(min = 0, max = 32)
	@Column(name = "residence")
	private String residence;
	
	@Size(min = 0, max = 1024)
	@Column(name = "about")
	private String about;
	
	@Column( name = "image")
	private String image;
	

	public DBEntry() {

	}

	public DBEntry(String greekName, String romanName, String consort, 
			String residence, String about, String image) {
		this.greekName = greekName;
		this.romanName = romanName;
		this.consort = consort;
		this.residence = residence;
		this.about = about;
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

	public String getGreekName() {
		return greekName;
	}

	public void setGreekName(String greekName) {
		this.greekName = greekName;
	}

	public String getRomanName() {
		return romanName;
	}

	public void setRomanName(String romanName) {
		this.romanName = romanName;
	}

	public String getConsort() {
		return consort;
	}

	public void setConsort(String consort) {
		this.consort = consort;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
