package com.entity;

public class OrderDetail {
	private int id;
	private Order order;
	private Product product;
	private double productPrice;
	private short quantity;
	
	public OrderDetail() {
		
	}
	
	public OrderDetail(int id, Order order, Product product, double productPrice, short quantity) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public short getQuantity() {
		return quantity;
	}
	
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	
}
