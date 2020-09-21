package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.AddressDao;
import com.entity.Address;
import com.entity.Customer;

public class AddressDaoImpl implements AddressDao {
	
	private Connection conn;
	
	public AddressDaoImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public List<Address> getAddressesByCustomer(Customer customer) throws Exception{
		List<Address> listOfAddress = new ArrayList<Address>();
		String sql = "select id, recipient_name, address, city_id, postal_code, is_default from addresses where user_id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, customer.getId());
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Address address = new Address();
			address.setId(rs.getInt("id"));
			address.setCustomer(customer);
			address.setRecipientName(rs.getString("recipient_name"));
			address.setAddress(rs.getString("address"));
			address.setCityId(rs.getInt("city_id"));
			address.setPostalCode(rs.getString("postal_code"));
			address.setDefault(rs.getBoolean("is_default"));
			listOfAddress.add(address);
		}
		return listOfAddress;
	}
	
	@Override
	public Address getAddressById(int id) throws Exception {
		Address temp = null;
		String sql = "select id, recipient_name, address, city_id, postal_code, is_default from addresses where id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			temp = new Address();
			temp.setId(rs.getInt("id"));
			temp.setRecipientName(rs.getString("recipient_name"));
			temp.setAddress(rs.getString("address"));
			temp.setCityId(rs.getInt("balance"));
			temp.setPostalCode(rs.getString("postal_code"));
			temp.setDefault(rs.getBoolean("is_default"));
		}
		return temp;
	}

	@Override
	public int addAddress(Address address) throws Exception {
		String sql = "insert into addresses(user_id, recipient_name, address, city_id, postal_code, is_default) values(?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, address.getCustomer().getId());
		pst.setString(2, address.getRecipientName());
		pst.setString(3, address.getAddress());
		pst.setInt(4, address.getCityId());
		pst.setString(5, address.getPostalCode());
		pst.setBoolean(6, address.isDefault());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}
	
	@Override
	public int updateAddress(Address address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAddress(int id) throws Exception {
		String sql = "delete from addresses where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}
}
