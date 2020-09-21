package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BrandDao;
import com.entity.Brand;

public class BrandDaoImpl implements BrandDao{

	private Connection conn;
	
	public BrandDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public List<Brand> getAllBrands() throws Exception {
		List<Brand> listOfBrand = new ArrayList<Brand>();
		String sql = "select id, name from brands";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Brand brand = new Brand();
			brand.setId(rs.getInt("id"));
			brand.setName(rs.getString("name"));
			listOfBrand.add(brand);
		}
		return listOfBrand;
	}

	@Override
	public Brand getBrandById(int id) throws Exception {
		Brand temp = null;
		String sql = "select id, name from brands where id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			temp = new Brand();
			temp.setId(rs.getInt("id"));
			temp.setName(rs.getString("name"));
		}
		return temp;
	}

	@Override
	public int addBrand(Brand brand) throws Exception{
		String sql = "insert into categories(name) values(?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, brand.getName());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBrand(int id) throws Exception {
		String sql = "delete from categories where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}
}
