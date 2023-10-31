package com.example.moviecatalogservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Catalog {
	
	@Id
	@GeneratedValue(generator = "movie_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "movie_gen", sequenceName = "movie_seq", initialValue = 1)
	private int id;
	private String name;
	private String desc;
	private int rating;
	
	public Catalog() {
		
	}
	
	public Catalog(String name, String desc, int rating) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
	
}
