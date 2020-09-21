package com.dao;

import java.util.List;

import com.entity.Product;

public interface ProductDao {
	public List<Product> getAllProducts() throws Exception;
	public Product getProductById(int id) throws Exception;
	public int addProduct(Product product) throws Exception;
	public int updateProduct(Product product) throws Exception;
	public int deleteProduct(int id) throws Exception;
}
