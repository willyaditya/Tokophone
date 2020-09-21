package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BrandDao;
import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entity.Brand;
import com.entity.Category;
import com.entity.Product;

public class ProductDaoImpl implements ProductDao {
	
	private Connection conn;
	
	public ProductDaoImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public List<Product> getAllProducts() throws Exception {
		List<Product> listOfProduct = new ArrayList<Product>();
		String sql = "select id, brand_id, category_id, name, price, description, color, slug, weight from products";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Product temp = new Product();
			temp.setId(rs.getInt("id"));
			temp.setName(rs.getString("name"));
			temp.setPrice(rs.getDouble("price"));
			temp.setDescription(rs.getString("description"));
			temp.setColor(rs.getString("color"));
			temp.setSlug(rs.getString("slug"));
			temp.setWeight(rs.getByte("weight"));

			BrandDao brandDao = new BrandDaoImpl(this.conn);
			CategoryDao categoryDao = new CategoryDaoImpl(this.conn);
			
			Brand brand = brandDao.getBrandById(rs.getInt("brand_id"));
			Category category = categoryDao.getCategoryById(rs.getInt("category_id"));
			
			temp.setBrand(brand);
			temp.setCategory(category);
			
			listOfProduct.add(temp);
		}
		return listOfProduct;
	}
	@Override
	public Product getProductById(int id) throws Exception {
		Product temp = null;
		String sql = "select id, brand_id, category_id, name, price, description, color, slug, weight from products where id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			temp = new Product();
			temp.setId(rs.getInt("id"));
			temp.setName(rs.getString("name"));
//			temp.setBrand();
//			temp.setCategory();
			temp.setPrice(rs.getDouble("price"));
			temp.setDescription(rs.getString("description"));
			temp.setColor(rs.getString("color"));
			temp.setSlug(rs.getString("slug"));
			temp.setWeight(rs.getByte("weight"));
		}
		return temp;
	}

	@Override
	public int addProduct(Product product) throws Exception {
		String sql = "insert into products(brand_id, category_id, name, price, description, color, slug, weight) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, product.getBrand().getId());
		pst.setInt(2, product.getCategory().getId());
		pst.setString(3, product.getName());
		pst.setDouble(4, product.getPrice());
		pst.setString(5, product.getDescription());
		pst.setString(6, product.getColor());
		pst.setString(7, product.getSlug());
		pst.setByte(8, product.getWeight());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) throws Exception {
		String sql = "delete from products where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}
}
