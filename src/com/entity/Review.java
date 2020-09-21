package com.entity;

public class Review {
	private String id;
	private Customer customer;
	private Product product;
	private String review;
	private float rating;
	
	public Review() {
		
	}
	
	public Review(String id, Customer customer, Product product, String review, float rating) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.review = review;
		this.rating = rating;
	}


	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getReview() {
		return review;
	}
	
	public void setReview(String review) {
		this.review = review;
	}

	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
