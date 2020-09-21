package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.CartDao;
import com.dao.CustomerDao;
import com.dao.ProductDao;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.Product;

public class CartDaoImpl implements CartDao {

	private Connection conn;
	
	public CartDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public List<Cart> getCartByCustomer(Customer customer) throws Exception {
		List<Cart> listOfCart = new ArrayList<Cart>();
		String sql = "select user_id, product_id, quantity from carts where user_id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, customer.getId());
		ResultSet rs = pst.executeQuery();
		
//		CustomerDao customerDao = new CustomerDaoImpl(this.conn);
		ProductDao productDao = new ProductDaoImpl(this.conn);
		
		while(rs.next()) {
			Cart cart = new Cart();
			cart.setCustomer(customer);
			
			Product product = productDao.getProductById(rs.getInt("product_id"));
			
			cart.setProduct(product);
			cart.setQuantity(rs.getByte("quantity"));
			listOfCart.add(cart);
		}
		return listOfCart;
	}

	@Override
	public Cart getCartByCustomerProduct(Customer customer, Product product) throws Exception {
		Cart cart = null;
		String sql = "select user_id, product_id, quantity from carts where user_id=? and product_id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, customer.getId());
		pst.setInt(2, product.getId());
		ResultSet rs = pst.executeQuery();
		
//		CustomerDao customerDao = new CustomerDaoImpl(this.conn);
		ProductDao productDao = new ProductDaoImpl(this.conn);
		
		while(rs.next()) {
			cart = new Cart();
			cart.setCustomer(customer);
			
			Product productTemp = productDao.getProductById(rs.getInt("product_id"));
			
			cart.setProduct(productTemp);
			cart.setQuantity(rs.getByte("quantity"));
		}
		return cart;
	}

	@Override
	public int addCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into carts(user_id, product_id, quantity) values(?,?,?)";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, cart.getCustomer().getId());
		pst.setInt(2, cart.getProduct().getId());
		pst.setShort(3, cart.getQuantity());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int removeCart(int customer_id, int product_id) throws Exception {
		String sql = "delete from carts where user_id=? and product_id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, customer_id);
		pst.setInt(2, product_id);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

}
