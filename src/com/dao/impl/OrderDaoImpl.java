package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dao.OrderDao;
import com.dao.AddressDao;
import com.entity.Customer;
import com.entity.Order;

public class OrderDaoImpl implements OrderDao {

	private Connection conn;
	
	public OrderDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public List<Order> getAllOrderByCustomer(Customer customer) throws Exception {
		List<Order> listOfOrder = new ArrayList<Order>();
		String sql = "select id, user_id, order_date, status, courier from orders where user_id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, customer.getId());
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			Order order = new Order();
			order.setCustomer(customer);
			order.setStatus(rs.getByte("status"));
			order.setCourier(rs.getString("courier"));
			Timestamp ts= rs.getTimestamp("order_date");  
            Date date=new Date(ts.getTime());
			order.setOrderDate(date);
			listOfOrder.add(order);
		}
		return listOfOrder;
	}

	@Override
	public Order getOrderById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOrder(Order order)  throws Exception{
		String sql = "insert into orders(user_id, order_date, status, courier) values(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		pst.setInt(1, order.getCustomer().getId());
		pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
		pst.setByte(3, order.getStatus());
		pst.setString(4, order.getCourier());
		int lastId = pst.executeUpdate();
		ResultSet rs = pst.getGeneratedKeys();
		int last_inserted_id = 0;
        if(rs.next())
        {
            last_inserted_id = rs.getInt(1);
        }
		return last_inserted_id;
	}

	@Override
	public int updateOrder(Order Order) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
