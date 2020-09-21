package com.dao;

import java.util.List;

import com.entity.Address;
import com.entity.Customer;

public interface AddressDao {
	public List<Address> getAddressesByCustomer(Customer customer) throws Exception;
	public Address getAddressById(int id) throws Exception;
	public int addAddress(Address address) throws Exception;
	public int updateAddress(Address address) throws Exception;
	public int deleteAddress(int id) throws Exception;
}
