package com.dao;

import java.util.List;

import com.entity.ProductImage;

public interface ProductImageDao {
	public List<ProductImage> getAllProductImages();
	public ProductImage getProductImageById(String id);
	public int addProductImage(ProductImage productImage);
	public int updateProductImage(ProductImage productImage);
	public int deleteProductImage(String id);
}
