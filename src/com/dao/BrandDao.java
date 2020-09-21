package com.dao;

import java.util.List;

import com.entity.Brand;

public interface BrandDao {
	public List<Brand> getAllBrands() throws Exception;
	public Brand getBrandById(int id) throws Exception;
	public int addBrand(Brand Brand) throws Exception;
	public int updateBrand(Brand Brand) throws Exception;
	public int deleteBrand(int id) throws Exception;
}
