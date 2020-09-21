package com.dao;

import java.util.List;

import com.entity.Category;

public interface CategoryDao {
	public List<Category> getAllCategories() throws Exception;
	public Category getCategoryById(int id) throws Exception;
	public int addCategory(Category category) throws Exception;
	public int updateCategory(Category category) throws Exception;
	public int deleteCategory(int id) throws Exception;
}
