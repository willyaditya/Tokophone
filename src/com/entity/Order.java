package com.entity;

import java.util.Date;

public class Order {
	private int id;
	private Customer customer;
	private Date orderDate;
	private byte status;
	private Address address;
	private String courier;
	
	public Order() {
		
	}
	
	public Order(int id, Customer customer, byte status, Address address, String courier) {
		super();
		this.id = id;
		this.customer = customer;
		this.status = status;
		this.address = address;
		this.courier = courier;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public byte getStatus() {
		return status;
	}
	
	public void setStatus(byte status) {
		this.status = status;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getCourier() {
		return courier;
	}
	
	public void setCourier(String courier) {
		this.courier = courier;
	}
	
}
