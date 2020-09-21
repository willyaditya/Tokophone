package com.entity;

public class Banner {
	private String id;
	private byte category;
	private String bannerImage;
	private byte status;
	
	public Banner() {
		
	}
	
	public Banner(String id, byte category, String bannerImage, byte status) {
		super();
		this.id = id;
		this.category = category;
		this.bannerImage = bannerImage;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public byte getCategory() {
		return category;
	}
	
	public void setCategory(byte category) {
		this.category = category;
	}
	
	public String getBannerImage() {
		return bannerImage;
	}
	
	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}
	
	public byte getStatus() {
		return status;
	}
	
	public void setStatus(byte status) {
		this.status = status;
	}
}
