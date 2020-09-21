package com.entity;

public class Cart {
	private String id;
	private Customer customer;
	private Product product;
	private short quantity;
	
	public Cart() {
		
	}
	
	public Cart(String id, Customer customer, Product product, short quantity) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
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
	
	public short getQuantity() {
		return quantity;
	}
	
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
}
