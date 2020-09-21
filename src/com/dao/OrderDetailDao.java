package com.dao;

import java.util.List;

import com.entity.Order;
import com.entity.OrderDetail;

public interface OrderDetailDao {
	public List<OrderDetail> getOrderDetailsByOrder(Order order) throws Exception;
	public int addOrderDetail(OrderDetail orderDetail) throws Exception;
	public int updateOrderDetail(OrderDetail orderDetail) throws Exception;
	public int deleteOrderDetail(int id) throws Exception;
}
