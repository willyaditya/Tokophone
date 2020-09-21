package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.dao.WishlistDao;
import com.entity.Customer;
import com.entity.Product;
import com.entity.Wishlist;

public class WishlistDaoImpl implements WishlistDao {

	private Connection conn;
	
	public WishlistDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public List<Wishlist> getWishlistByCustomer(Customer customer) throws Exception {
		List<Wishlist> listOfWishlists = new ArrayList<Wishlist>();
		String sql = "select user_id, product_id from wishlists where user_id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, customer.getId());
		ResultSet rs = pst.executeQuery();
		
//		CustomerDao customerDao = new CustomerDaoImpl(this.conn);
		ProductDao productDao = new ProductDaoImpl(this.conn);
		
		while(rs.next()) {
			Wishlist wishlist = new Wishlist();
			wishlist.setCustomer(customer);
			
			Product product = productDao.getProductById(rs.getInt("product_id"));
			
			wishlist.setProduct(product);
			listOfWishlists.add(wishlist);
		}
		return listOfWishlists;
	}
	
	@Override
	public Wishlist getWishlistByCustomerProduct(Customer customer, Product product) throws Exception {
		Wishlist wishlist = null;
		String sql = "select user_id, product_id from wishlists where user_id=? and product_id=?";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, customer.getId());
		pst.setInt(2, product.getId());
		ResultSet rs = pst.executeQuery();
		
//		CustomerDao customerDao = new CustomerDaoImpl(this.conn);
		ProductDao productDao = new ProductDaoImpl(this.conn);
		
		while(rs.next()) {
			wishlist = new Wishlist();
			wishlist.setCustomer(customer);
			
			Product productTemp = productDao.getProductById(rs.getInt("product_id"));
			
			wishlist.setProduct(productTemp);
		}
		return wishlist;
	}

	@Override
	public int addWishlist(Wishlist wishlist) throws Exception {
		String sql = "insert into wishlists(user_id, product_id) values(?,?)";
		PreparedStatement pst = this.conn.prepareStatement(sql);
		pst.setInt(1, wishlist.getCustomer().getId());
		pst.setInt(2, wishlist.getProduct().getId());
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

	@Override
	public int removeWishlist(int customer_id, int product_id) throws Exception {
		String sql = "delete from wishlists where user_id=? and product_id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, customer_id);
		pst.setInt(2, product_id);
		int affectedRow = pst.executeUpdate();
		return affectedRow;
	}

}
