package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dao.OrderDetailDao;
import com.dao.ProductDao;
import com.entity.Order;
import com.entity.OrderDetail;
import com.entity.Product;

public class OrderDetailDaoImpl implements OrderDetailDao {

	private Connection conn;
	
	public OrderDetailDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public List<OrderDetail> getOrderDetailsByOrder(Order order) throws Exception {
		List<OrderDetail> listOfOrderDetail = new ArrayList<OrderDetail>();
		String sql = "select id, user_id, order_date, status, courier from orders where user_id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, order.getId());
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			
			ProductDao productDao = new ProductDaoImpl(this.conn);
			
			Product product = productDao.getProductById(rs.getInt("product_id"));
			orderDetail.setProduct(product);
			orderDetail.setProductPrice(product.getPrice());			
			listOfOrderDetail.add(orderDetail);
		}
		return listOfOrderDetail;
	}

	@Override
	public int addOrderDetail(OrderDetail orderDetail) throws Exception {
		String sql = "insert into orderdetails(order_id, product_id, product_price, quantity) values(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, orderDetail.getOrder().getId());
		pst.setInt(2, orderDetail.getProduct().getId());
		pst.setDouble(3, orderDetail.getProductPrice());
		pst.setShort(4, orderDetail.getQuantity());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int updateOrderDetail(OrderDetail orderDetail) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrderDetail(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
