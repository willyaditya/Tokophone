package com.entity;

public class ProductImage {
	private String id;
	private Product product;
	private String product_image;
	
	public ProductImage() {
		
	}

	public ProductImage(String id, Product product, String product_image) {
		super();
		this.id = id;
		this.product = product;
		this.product_image = product_image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
}
