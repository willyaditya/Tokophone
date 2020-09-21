package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.dao.CustomerDao;
import com.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private Connection conn;
	
	public CustomerDaoImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		List<Customer> listOfCustomer = new ArrayList<Customer>();
		String sql = "select id, name, email, balance, phone_number, profile_image from users";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Customer cust = new Customer();
			cust.setId(rs.getInt("id"));
			cust.setName(rs.getString("name"));
			cust.setEmail(rs.getString("email"));
			cust.setBalance(rs.getDouble("balance"));
			cust.setPhoneNumber(rs.getString("phone_number"));
			cust.setProfileImage(rs.getString("profile_image"));
			listOfCustomer.add(cust);
		}
		return listOfCustomer;
	}
	
	@Override
	public Customer getCustomerById(int id) throws Exception {
		Customer cust = null;
		String sql = "select id, name, email, balance, phone_number, profile_image from users where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			cust = new Customer();
			cust.setId(rs.getInt("id"));
			cust.setName(rs.getString("name"));
			cust.setEmail(rs.getString("email"));
			cust.setBalance(rs.getDouble("balance"));
			cust.setPhoneNumber(rs.getString("phone_number"));
			cust.setProfileImage(rs.getString("profile_image"));
		}
		return cust;
	}
	
	@Override
	public Customer getCustomerByEmail(String email) throws Exception {
		Customer cust = null;
		String sql = "select id, name, email, password, balance, phone_number, profile_image from users where email=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			cust = new Customer();
			cust.setId(rs.getInt("id"));
			cust.setName(rs.getString("name"));
			cust.setEmail(rs.getString("email"));
			cust.setPassword(rs.getString("password"));
			cust.setBalance(rs.getDouble("balance"));
			cust.setPhoneNumber(rs.getString("phone_number"));
			cust.setProfileImage(rs.getString("profile_image"));
		}
		return cust;
	}
	
	public int addCustomer(Customer cust) throws Exception {
		String sql = "insert into users(name, email, password, balance, phone_number, profile_image) values(?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, cust.getName());
		pst.setString(2, cust.getEmail());
		pst.setString(3, cust.getPassword());
		pst.setDouble(4, cust.getBalance());
		pst.setString(5, cust.getPhoneNumber());
		pst.setString(6, cust.getProfileImage());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int updateCustomer(Customer customer) {
		
		return 0;
	}
	
	@Override
	public int deleteCustomer(int id) throws Exception {
		String sql = "delete from users where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

}
