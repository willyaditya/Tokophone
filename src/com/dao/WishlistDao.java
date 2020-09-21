package com.dao;

import java.util.List;

import com.entity.Customer;
import com.entity.Product;
import com.entity.Wishlist;

public interface WishlistDao {
	public List<Wishlist> getWishlistByCustomer(Customer customer) throws Exception;
	public Wishlist getWishlistByCustomerProduct(Customer customer, Product product) throws Exception;
	public int addWishlist(Wishlist wishlist) throws Exception;
	public int removeWishlist(int customer_id, int product_id) throws Exception;
}
