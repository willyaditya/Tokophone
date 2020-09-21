package com.entity;

public class Transfer {
	private String id;
	private int recipientId;
	private double total;
	private byte status;

	public Transfer() {
		
	}
	
	public Transfer(String id, int recipientId, double total, byte status) {
		super();
		this.id = id;
		this.recipientId = recipientId;
		this.total = total;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

}
