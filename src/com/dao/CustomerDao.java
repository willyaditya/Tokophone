package com.dao;

import java.util.List;

import com.entity.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers() throws Exception;
	public Customer getCustomerById(int id) throws Exception;
	public Customer getCustomerByEmail(String email) throws Exception;
	public int addCustomer(Customer customer) throws Exception;
	public int updateCustomer(Customer customer) throws Exception;
	public int deleteCustomer(int id) throws Exception;
}
