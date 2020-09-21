package com.entity;

public class Address {
	private int id;
	private Customer customer;
	private String recipientName;
	private String address;
	private int cityId;
	private String postalCode;
	private boolean isDefault;
	
	public Address() {
		
	}
	
	public Address(int id, String recipientName, String address, int cityId, String postalCode, boolean isDefault) {
		super();
		this.id = id;
		this.recipientName = recipientName;
		this.address = address;
		this.cityId = cityId;
		this.postalCode = postalCode;
		this.isDefault = isDefault;
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
	
	public String getRecipientName() {
		return recipientName;
	}
	
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getCityId() {
		return cityId;
	}
	
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public boolean isDefault() {
		return isDefault;
	}
	
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	
}
