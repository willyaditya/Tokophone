package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.CategoryDao;
import com.entity.Category;

public class CategoryDaoImpl implements CategoryDao {

	private Connection conn;
	
	public CategoryDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public List<Category> getAllCategories() throws Exception {
		List<Category> listOfCategory = new ArrayList<Category>();
		String sql = "select id, name, slug from categories";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			category.setSlug(rs.getString("slug"));
			listOfCategory.add(category);
		}
		return listOfCategory;
	}

	@Override
	public Category getCategoryById(int id) throws Exception {
		Category temp = null;
		String sql = "select id, name, slug from categories where id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			temp = new Category();
			temp.setId(rs.getInt("id"));
			temp.setName(rs.getString("name"));
			temp.setSlug(rs.getString("slug"));
		}
		return temp;
	}

	@Override
	public int addCategory(Category category) throws Exception{
		String sql = "insert into categories(name, slug) values(?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, category.getName());
		pst.setString(2, category.getSlug());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(int id) throws Exception {
		String sql = "delete from categories where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

}
