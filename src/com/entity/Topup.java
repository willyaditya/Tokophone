package com.entity;

public class Topup {
	private String id;
	private double total;
	private byte status;

	public Topup(String id, double total, byte status) {
		super();
		this.id = id;
		this.total = total;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
