package com.entity;

public class Category {
	private int id;
	private String name;
	private int parent_id;
	private String slug;
	
	public Category() {
		
	}
	
	public Category(int id, String name, int parent_id, String slug) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.slug = slug;
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
	
	public int getParent_id() {
		return parent_id;
	}
	
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}

}
