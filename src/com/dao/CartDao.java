package com.dao;

import java.util.List;

import com.entity.Cart;
import com.entity.Customer;
import com.entity.Product;

public interface CartDao {
	public List<Cart> getCartByCustomer(Customer customer) throws Exception;
	public Cart getCartByCustomerProduct(Customer customer, Product product) throws Exception;
	public int addCart(Cart cart) throws Exception;
	public int removeCart(int customer_id, int product_int) throws Exception;
}
