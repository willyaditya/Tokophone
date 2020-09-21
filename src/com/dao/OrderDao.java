package com.dao;

import java.util.List;

import com.entity.Customer;
import com.entity.Order;

public interface OrderDao {
	public List<Order> getAllOrderByCustomer(Customer customer) throws Exception;
	public Order getOrderById(String id) throws Exception;
	public int addOrder(Order Order) throws Exception;
	public int updateOrder(Order Order) throws Exception;
	public int deleteOrder(String id) throws Exception;
}
